# -*- coding: utf-8 -*-
"""Normalize the bundled AutoJs6 documentation to the current reference style."""

from __future__ import annotations

import argparse
import html
import re
from collections import Counter
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
DOCS_DIR = ROOT / "app" / "src" / "main" / "assets" / "docs"

TYPE_LINKS = {
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/"
        "Data_structures#Boolean_type",
        "boolean",
    ): "dataTypes.html#datatypes_boolean",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/"
        "Data_structures#Number_type",
        "number",
    ): "dataTypes.html#datatypes_number",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/"
        "Data_structures#String_type",
        "string",
    ): "dataTypes.html#datatypes_string",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/"
        "Data_structures#Symbol_type",
        "symbol",
    ): "dataTypes.html#datatypes_symbol",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/"
        "Global_Objects/Array",
        "Array",
    ): "dataTypes.html#datatypes_array",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/"
        "Global_Objects/ArrayBuffer",
        "ArrayBuffer",
    ): "dataTypes.html#datatypes_arraybuffer",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/"
        "Global_Objects/DataView",
        "DataView",
    ): "dataTypes.html#datatypes_dataview",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/"
        "Global_Objects/Function",
        "Function",
    ): "dataTypes.html#datatypes_function",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/"
        "Global_Objects/Object",
        "Object",
    ): "dataTypes.html#datatypes_object",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/"
        "Global_Objects/TypedArray",
        "TypedArray",
    ): "dataTypes.html#datatypes_typedarray",
    (
        "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/"
        "Global_Objects/Uint8Array",
        "Uint8Array",
    ): "dataTypes.html#datatypes_uint8array",
}
TYPE_LINK_TARGETS = {source: target for (source, _), target in TYPE_LINKS.items()}

# These phrases describe the current application. Historical names, third-party
# project names, compatibility discussions, and Auto.js Pro references stay intact.
CURRENT_PRODUCT_REPLACEMENTS = (
    (
        "如果在Auto.js中运行则为Auto.js的版本号",
        "如果在AutoJs6中运行则为AutoJs6的版本号",
    ),
    (
        "如果在Auto.js中运行则为Auto.js的版本名称",
        "如果在AutoJs6中运行则为AutoJs6的版本名称",
    ),
    ("Auto.js版本号", "AutoJs6版本号"),
    ("Auto.js版本名称", "AutoJs6版本名称"),
    ("launchApp(&quot;Auto.js&quot;)", "launchApp(&quot;AutoJs6&quot;)"),
    (
        "启动Auto.js的特定界面. 该函数在Auto.js内运行则会打开Auto.js内的界面",
        "启动AutoJs6的特定界面. 该函数在AutoJs6内运行则会打开AutoJs6内的界面",
    ),
    ("Auto.js的设置界面", "AutoJs6的设置界面"),
    (
        "发送以上特定名称的广播可以触发Auto.js的布局分析, "
        "方便脚本调试. 这些广播在Auto.js发送才有效",
        "发送以上特定名称的广播可以触发AutoJs6的布局分析, "
        "方便脚本调试. 这些广播在AutoJs6发送才有效",
    ),
    ("屏幕上有Auto.js和QQ两个应用", "屏幕上有AutoJs6和QQ两个应用"),
    (
        "其他设备上AutoJs会自动放缩坐标",
        "其他设备上AutoJs6会自动放缩坐标",
    ),
    (
        "只能在Auto.js的界面保持屏幕常亮",
        "只能在AutoJs6的界面保持屏幕常亮",
    ),
    (
        "但Auto.js软件本身的toast除外",
        "但AutoJs6软件本身的toast除外",
    ),
    ("尽管Auto.js通过各种方式", "尽管AutoJs6通过各种方式"),
    (
        "Auto.js 有一个简单的模块加载系统.  在 Auto.js 中",
        "AutoJs6 有一个简单的模块加载系统.  在 AutoJs6 中",
    ),
    ("目前Auto.js只能额外申请两个权限", "目前AutoJs6只能额外申请两个权限"),
    (
        "增加Auto.js以及Auto.js打包的应用的权限",
        "增加AutoJs6以及AutoJs6打包的应用的权限",
    ),
    ("在Auto.js大致等同于用adb执行命令", "在AutoJs6大致等同于用adb执行命令"),
    (
        "在Auto.js中, 线程间变量在符合JavaScript变量作用域规则的前提下是共享的",
        "在AutoJs6中, 线程间变量在符合JavaScript变量作用域规则的前提下是共享的",
    ),
    (
        "Rhino和Auto.js提供了一些简单的设施来解决简单的线程安全问题",
        "Rhino和AutoJs6提供了一些简单的设施来解决简单的线程安全问题",
    ),
    (
        "Auto.js提供了一些简单的设施来支持简单的线程通信",
        "AutoJs6提供了一些简单的设施来支持简单的线程通信",
    ),
    (
        "Auto.js 中的计时器函数实现了与 Web 浏览器提供的定时器类似的 API",
        "AutoJs6 中的计时器函数实现了与 Web 浏览器提供的定时器类似的 API",
    ),
    ("Auto.js 不能保证回调被触发的确切时间", "AutoJs6 不能保证回调被触发的确切时间"),
    (
        "Auto.js的UI系统来自于Android, 所有属性和方法都能在Android源码中找到. "
        "如果某些代码或属性没有出现在Auto.js的文档中",
        "AutoJs6的UI系统来自于Android, 所有属性和方法都能在Android源码中找到. "
        "如果某些代码或属性没有出现在AutoJs6的文档中",
    ),
    ("Hello, Auto.js UI", "Hello, AutoJs6 UI"),
    ("Auto.js会自动使用适当的缓存", "AutoJs6会自动使用适当的缓存"),
    (
        "packageName: &quot;org.autojs.autojs&quot;",
        "packageName: &quot;org.autojs.autojs6&quot;",
    ),
)

ASCII_PUNCTUATION = {
    "\u201c": "&quot;",
    "\u201d": "&quot;",
    "\u3000": "&nbsp;",
    "\u300a": "&quot;",
    "\u300b": "&quot;",
    "\u3011": "]",
    "\uff01": "!",
}
ASCII_PUNCTUATION_ENTITIES = {
    "&ndash;": "-",
    "&mdash;": "-",
    "&lsquo;": "&#39;",
    "&rsquo;": "&#39;",
    "&sbquo;": "&#39;",
    "&ldquo;": "&quot;",
    "&rdquo;": "&quot;",
    "&bdquo;": "&quot;",
    "&hellip;": "...",
}
ALLOWED_LEGACY_AUTOJS_LINE_MARKERS = (
    "Auto.js Pro",
    "Auto.js DevTools",
    "Auto.js 4",
    "Auto.js 应用",
    "github.com/hyb1996/Auto.js",
    "github.com/TonyJiangWJ/Auto.js",
    ">Auto.js</td>",
    "Auto.js图标",
)

PROHIBITED_SYMBOL_PATTERN = re.compile(
    r"[\u2010-\u2027\u3000-\u303F\u30FB\uFE10-\uFE6F\uFF00-\uFFEF]",
)
CODE_BLOCK_PATTERN = re.compile(
    r"(?P<open><pre><code(?P<attributes>[^>]*)>)(?P<body>.*?)(?P<close></code></pre>)",
    re.DOTALL,
)
HTML_ANCHOR_PATTERN = re.compile(
    r"<a\b(?P<attributes>[^>]*)>(?P<body>.*?)</a>",
    re.IGNORECASE | re.DOTALL,
)
HTML_ATTRIBUTE_PATTERN = re.compile(
    r"""(?P<name>[A-Za-z_:][-A-Za-z0-9_:.]*)\s*=\s*"""
    r"""(?P<quote>["'])(?P<value>.*?)(?P=quote)""",
    re.DOTALL,
)
HTML_ENTITY_PATTERN = re.compile(
    r"&(?:#(?:[xX][0-9A-Fa-f]+|[0-9]+)|[A-Za-z][A-Za-z0-9]+);",
)
VAR_DECLARATION_PATTERN = re.compile(
    r"\bvar(?=\s+(?:[A-Za-z_$]|\{|\[))",
)
FULL_WIDTH_CLOSE_PARENTHESIS_BEFORE_TEXT_PATTERN = re.compile(
    r"\uff09(?=[A-Za-z0-9_$\u3040-\u30FF\u3400-\u4DBF\u4E00-\u9FFF"
    r"\uAC00-\uD7AF\uF900-\uFAFF])",
)
CODE_TYPED_NAME_PATTERN = re.compile(
    r"<li>(<p>)?<code>((?:\.{2,3})?[A-Za-z_$][A-Za-z0-9_$]*(?:\(\))?)</code>"
    r"([ \t]*\{)",
)
COMBINED_TYPED_NAME_PATTERN = re.compile(
    r"<li>(<p>)?("
    r"[A-Za-z_$][A-Za-z0-9_$]*(?:[ \t]*,[ \t]*[A-Za-z_$][A-Za-z0-9_$]*)+"
    r")([ \t]+\{)",
)
PLAIN_TYPED_NAME_PATTERN = re.compile(
    r"<li>(<p>)?((?!(?:return|returns)\b)[A-Za-z_$][A-Za-z0-9_$]*(?:\(\))?)"
    r"([ \t]+\{)",
    re.IGNORECASE,
)
BRACED_RETURN_PATTERN = re.compile(
    r"<li>(<p>)?(?:返回|Returns:)([ \t]*\{)",
    re.IGNORECASE,
)
LINKED_RETURN_PATTERN = re.compile(
    r'<li>返回\s*(?P<link><a href="[^"]+">(?:ScriptSource|SensorEventEmitter|'
    r"Thread|Disposable|AtomicLong|ReentrantLock)</a>)</li>",
)
PROHIBITED_CONTROL_PATTERN = re.compile(r"[\x00-\x08\x0B\x0C\x0E-\x1F\x7F]")
TRAILING_HORIZONTAL_WHITESPACE_PATTERN = re.compile(r"[ \t]+(?=\r?$)", re.MULTILINE)
PUNCTUATION_SPACE_BEFORE_NON_TEXT_PATTERN = re.compile(
    r"([,;:])[ \t]+(?=(?:</|<br\b))",
    re.IGNORECASE,
)
LEGACY_MARKER_PATTERN = re.compile(
    r'<hr>\n'
    r'<p style="font: italic 1em sans-serif; color: #78909C">'
    r"此章节待补充或完善\.\.\.</p>\n"
    r'<p style="font: italic 1em sans-serif; color: #78909C">'
    r"Marked by (?P<author>[A-Za-z0-9_-]+) on "
    r"(?P<month>[A-Z][a-z]{2}) (?P<day>\d{1,2}), (?P<year>\d{4})\.</p>\n\n"
    r"<hr>",
)
MONTHS = {
    "Jan": 1,
    "Feb": 2,
    "Mar": 3,
    "Apr": 4,
    "May": 5,
    "Jun": 6,
    "Jul": 7,
    "Aug": 8,
    "Sep": 9,
    "Oct": 10,
    "Nov": 11,
    "Dec": 12,
}


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--check",
        action="store_true",
        help="report files that are not normalized without modifying them",
    )
    return parser.parse_args()


def add_stat(stats: Counter, key: str, count: int) -> None:
    if count:
        stats[key] += count


def anchor_attributes(raw_attributes: str) -> list[tuple[str, str, str]]:
    return [
        (match.group("name").lower(), match.group("value"), match.group(0))
        for match in HTML_ATTRIBUTE_PATTERN.finditer(raw_attributes)
    ]


def mdn_type_link_details(match: re.Match[str]) -> tuple[str, list[str]] | None:
    attributes = anchor_attributes(match.group("attributes"))
    values = {name: value for name, value, _ in attributes}
    source = values.get("href")
    classes = values.get("class", "").split()
    if source is None or "type" not in classes or not source.startswith(
        "https://developer.mozilla.org/"
    ):
        return None
    return source, classes


def replace_type_links(text: str, stats: Counter) -> str:
    def replace_link(match: re.Match[str]) -> str:
        details = mdn_type_link_details(match)
        if details is None:
            return match.group(0)
        source, classes = details
        target = TYPE_LINK_TARGETS.get(source)
        if target is None:
            return match.group(0)
        attributes = anchor_attributes(match.group("attributes"))
        extra_attributes = [
            raw for name, _, raw in attributes if name not in {"class", "href"}
        ]
        remaining_classes = [name for name in classes if name != "type"]
        if remaining_classes:
            class_value = html.escape(" ".join(remaining_classes), quote=True)
            extra_attributes.append(f'class="{class_value}"')
        suffix = "".join(f" {attribute}" for attribute in extra_attributes)
        stats["type_links"] += 1
        return (
            f'<span class="type"><a href="{target}"{suffix}>'
            f'{match.group("body")}</a></span>'
        )

    return HTML_ANCHOR_PATTERN.sub(replace_link, text)


def replace_current_product_names(text: str, stats: Counter) -> str:
    for old, new in CURRENT_PRODUCT_REPLACEMENTS:
        count = text.count(old)
        if count:
            text = text.replace(old, new)
            stats["current_product_phrases"] += count
    return text


def replace_legacy_marker(match: re.Match[str]) -> str:
    month = MONTHS.get(match.group("month"))
    if month is None:
        raise ValueError(f"Unsupported marker month: {match.group('month')}")
    marked_on = (
        f"{int(match.group('year')):04d}-{month:02d}-{int(match.group('day')):02d}"
    )
    return (
        "<hr>\n"
        '<aside class="doc-status doc-status--incomplete" '
        f'data-marked-by="{match.group("author")}" data-marked-on="{marked_on}">\n'
        "<p><strong>文档状态:</strong> 此章节仍在补充或完善中.</p>\n"
        "</aside>"
    )


def normalize_markers(text: str, stats: Counter) -> str:
    normalized, count = LEGACY_MARKER_PATTERN.subn(replace_legacy_marker, text)
    add_stat(stats, "incomplete_markers", count)
    return normalized


def should_preserve_var(attributes: str, body: str) -> bool:
    if "lang-kotlin" in attributes.lower():
        return True
    if "var sales = &lt;sales" in body and "for each( var price" in body:
        return True
    return all(
        declaration in body
        for declaration in (
            "let selector = 1;",
            "const selector = 1;",
            "var selector = 1;",
        )
    )


def normalize_code_blocks(text: str, stats: Counter) -> str:
    def replace_code_block(match: re.Match[str]) -> str:
        body = match.group("body")
        if should_preserve_var(match.group("attributes"), body):
            return match.group(0)
        normalized_body, count = VAR_DECLARATION_PATTERN.subn("let", body)
        add_stat(stats, "var_declarations", count)
        return f"{match.group('open')}{normalized_body}{match.group('close')}"

    text = CODE_BLOCK_PATTERN.sub(replace_code_block, text)
    typo_count = text.count("cosnt csvPath")
    if typo_count:
        text = text.replace("cosnt csvPath", "const csvPath")
        add_stat(stats, "const_typos", typo_count)
    text, count = re.subn(
        r"(?m)^(?P<indent>[ \t]*)r = http\.postJson",
        r"\g<indent>let r = http.postJson",
        text,
    )
    add_stat(stats, "implicit_http_variables", count)
    return text


def normalize_known_text_issues(text: str, stats: Counter) -> str:
    replacements = (
        ("verionName", "versionName"),
        ("Emiiter", "Emitter"),
        (
            '<span class="type">Boolea</span>',
            '<span class="type"><a href="dataTypes.html#datatypes_boolean">'
            "boolean</a></span>",
        ),
        ("最快的更新频率]</li>", "最快的更新频率</li>"),
        ("应用的签名信息(已弃用</li>", "应用的签名信息 (已弃用)</li>"),
        ("应用的签名信息 (已弃用</li>", "应用的签名信息 (已弃用)</li>"),
    )
    for old, new in replacements:
        count = text.count(old)
        if count:
            text = text.replace(old, new)
            stats["known_text_issues"] += count
    control_count = len(PROHIBITED_CONTROL_PATTERN.findall(text))
    if control_count:
        text = PROHIBITED_CONTROL_PATTERN.sub("", text)
        stats["control_characters"] += control_count
    text, count = PUNCTUATION_SPACE_BEFORE_NON_TEXT_PATTERN.subn(r"\1", text)
    add_stat(stats, "non_text_punctuation_spaces", count)
    text, count = TRAILING_HORIZONTAL_WHITESPACE_PATTERN.subn("", text)
    add_stat(stats, "trailing_whitespace", count)
    return text


def normalize_signatures(text: str, stats: Counter) -> str:
    text, count = CODE_TYPED_NAME_PATTERN.subn(
        r"<li>\1<strong>\2</strong>\3",
        text,
    )
    add_stat(stats, "typed_code_names", count)
    text, count = COMBINED_TYPED_NAME_PATTERN.subn(
        r"<li>\1<strong>\2</strong>\3",
        text,
    )
    add_stat(stats, "typed_combined_names", count)
    text, count = PLAIN_TYPED_NAME_PATTERN.subn(
        r"<li>\1<strong>\2</strong>\3",
        text,
    )
    add_stat(stats, "typed_plain_names", count)
    text, count = BRACED_RETURN_PATTERN.subn(
        r"<li>\1<ins><strong>returns</strong></ins>\2",
        text,
    )
    add_stat(stats, "return_labels", count)
    text, count = LINKED_RETURN_PATTERN.subn(
        r'<li><ins><strong>returns</strong></ins> { <span class="type">'
        r"\g<link></span> }</li>",
        text,
    )
    add_stat(stats, "linked_return_labels", count)
    callback_return = "<li>返回 callback的执行结果</li>"
    callback_return_replacement = (
        '<li><ins><strong>returns</strong></ins> { '
        '<span class="type"><a href="dataTypes.html#datatypes_any">any</a></span> '
        "} callback 的执行结果</li>"
    )
    count = text.count(callback_return)
    if count:
        text = text.replace(callback_return, callback_return_replacement)
        stats["callback_return_labels"] += count
    return text


def normalize_ascii_punctuation(text: str, stats: Counter) -> str:
    for old, new in ASCII_PUNCTUATION_ENTITIES.items():
        count = text.count(old)
        if count:
            text = text.replace(old, new)
            stats["prohibited_symbol_entities"] += count
    for old, new in (("\u3001", ", "), ("\uff1a", ": "), ("\uff1b", "; ")):
        text, count = re.subn(f"{old}[ \\t]*", new, text)
        add_stat(stats, "full_width_symbols", count)
    text, count = re.subn(r"(?<![ \t])\uff08[ \t]*", " (", text)
    add_stat(stats, "full_width_symbols", count)
    text, count = re.subn(r"\uff08[ \t]*", "(", text)
    add_stat(stats, "full_width_symbols", count)
    text, count = FULL_WIDTH_CLOSE_PARENTHESIS_BEFORE_TEXT_PATTERN.subn(") ", text)
    add_stat(stats, "full_width_symbols", count)
    text, count = re.subn("\uff09", ")", text)
    add_stat(stats, "full_width_symbols", count)

    def replace_em_dash_run(match: re.Match[str]) -> str:
        return "-" * len(match.group()) if len(match.group()) > 1 else " - "

    text, count = re.subn("\u2014+", replace_em_dash_run, text)
    add_stat(stats, "full_width_symbols", count)
    for old, new in ASCII_PUNCTUATION.items():
        count = text.count(old)
        if count:
            text = text.replace(old, new)
            stats["full_width_symbols"] += count
    return text


def normalize(text: str, stats: Counter) -> str:
    text = normalize_markers(text, stats)
    text = replace_type_links(text, stats)
    text = replace_current_product_names(text, stats)
    text = normalize_code_blocks(text, stats)
    text = normalize_known_text_issues(text, stats)
    text = normalize_signatures(text, stats)
    text = normalize_ascii_punctuation(text, stats)
    return normalize_known_text_issues(text, stats)


def validate(text: str, path: Path) -> None:
    relative = path.relative_to(ROOT)
    match = PROHIBITED_SYMBOL_PATTERN.search(text)
    if match:
        code_point = f"U+{ord(match.group()):04X}"
        raise ValueError(
            f"Prohibited full-width symbol {match.group()!r} ({code_point}) in {relative}"
        )
    for entity_match in HTML_ENTITY_PATTERN.finditer(text):
        decoded = html.unescape(entity_match.group())
        prohibited = PROHIBITED_SYMBOL_PATTERN.search(decoded)
        if prohibited:
            code_point = f"U+{ord(prohibited.group()):04X}"
            raise ValueError(
                f"Prohibited symbol entity {entity_match.group()!r} "
                f"({code_point}) in {relative}"
            )
    if "此章节待补充或完善..." in text or "Marked by SuperMonster003 on" in text:
        raise ValueError(f"Legacy incomplete-section marker in {relative}")
    if any(
        mdn_type_link_details(match) is not None
        for match in HTML_ANCHOR_PATTERN.finditer(text)
    ):
        raise ValueError(f"External MDN type link in {relative}")
    if re.search(r"AutoJs(?!6|Pro|-Docs)", text):
        raise ValueError(f"Legacy bare AutoJs product name in {relative}")
    if 'packageName: &quot;org.autojs.autojs&quot;' in text:
        raise ValueError(f"Legacy current-product package name in {relative}")
    for line_number, line in enumerate(text.splitlines(), 1):
        if "Auto.js" in line and not any(
            marker in line for marker in ALLOWED_LEGACY_AUTOJS_LINE_MARKERS
        ):
            raise ValueError(
                f"Auto.js outside an allowed historical context in "
                f"{relative}:{line_number}"
            )
    if "cosnt csvPath" in text:
        raise ValueError(f"Misspelled const declaration in {relative}")
    if re.search(r"应用的签名信息\s*\(已弃用</li>", text):
        raise ValueError(f"Unclosed deprecation note in {relative}")
    if re.search(r"(?m)^[ \t]*r = http\.postJson", text):
        raise ValueError(f"Implicit HTTP example variable in {relative}")
    if CODE_TYPED_NAME_PATTERN.search(text) or PLAIN_TYPED_NAME_PATTERN.search(text):
        raise ValueError(f"Legacy typed-name signature in {relative}")
    if COMBINED_TYPED_NAME_PATTERN.search(text):
        raise ValueError(f"Legacy combined-name signature in {relative}")
    if BRACED_RETURN_PATTERN.search(text):
        raise ValueError(f"Legacy return signature in {relative}")
    if LINKED_RETURN_PATTERN.search(text) or "<li>返回 callback的执行结果</li>" in text:
        raise ValueError(f"Legacy natural-language return signature in {relative}")
    control = PROHIBITED_CONTROL_PATTERN.search(text)
    if control:
        code_point = f"U+{ord(control.group()):04X}"
        raise ValueError(f"Prohibited control character {code_point} in {relative}")


def read_lf(path: Path) -> str:
    with path.open("r", encoding="utf-8", newline=None) as source:
        return source.read()


def write_lf(path: Path, text: str) -> None:
    with path.open("w", encoding="utf-8", newline="\n") as target:
        target.write(text)


def main() -> int:
    args = parse_args()
    paths = sorted(DOCS_DIR.rglob("*.html"))
    if not paths:
        raise FileNotFoundError(f"No HTML documentation found in {DOCS_DIR}")

    changed = []
    stats: Counter = Counter()
    for path in paths:
        original = read_lf(path)
        normalized = normalize(original, stats)
        validate(normalized, path)
        if normalized != original:
            changed.append(path)
            if not args.check:
                write_lf(path, normalized)

    if args.check and changed:
        print("Offline documentation requires normalization:")
        for path in changed:
            print(f"  {path.relative_to(ROOT).as_posix()}")
        return 1

    action = "checked" if args.check else "normalized"
    summary = [f"files={len(paths)}", f"changed={len(changed)}"]
    summary.extend(f"{key}={value}" for key, value in sorted(stats.items()))
    print(f"Offline documentation {action}: {', '.join(summary)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
