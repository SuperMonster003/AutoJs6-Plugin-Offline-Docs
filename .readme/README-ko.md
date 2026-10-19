<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>AutoJs6용 오프라인 문서 6.8.0 콘텐츠 플러그인</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 언어 (Languages)

******

현재 README.md는 다음 언어를 지원합니다:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- 한국어 [ko] # 현재
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### 소개

******

AutoJs6 Offline Documentation 플러그인은 전체 6.8.0 문서 사이트를 독립적으로 설치할 수 있는 콘텐츠 패키지로 제공합니다.

******

### 플러그인 계약

******

```text
applicationId=io.github.supermonster003.autojs6.plugin.offlinedocs
pluginId=offline-docs
engine=offline-docs
variant=6.8.0
contractVersion=1
requiredHostVersionCode=5240
contentVersion=6.8.0
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=220
totalBytes=14324696
contentSha256=99c55c1ad78865db5933cf78afc4ed5796d6164bb7e2116f433362f7300b1d26
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=20bc81da984d8559d8a91e2fff0111bd3a51637f
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService는 IPluginInfoProvider를 통해 PluginInfo를 제공합니다. 호스트는 고정 패키지가 활성화, 호환성, 서명, 메타데이터, 인벤토리 및 파일 콘텐츠 일관성 검사를 통과한 경우에만 플러그인을 허용합니다.

******

### 콘텐츠

******

`assets/docs/`의 현재 문서 자산에서 콘텐츠 메타데이터와 인벤토리를 자동으로 파생합니다. 호스트는 메타데이터, 인벤토리 및 파일 콘텐츠가 서로 일치하는지 검증합니다. 오프라인 문서는 제목과 본문을 대상으로 전체 텍스트 검색을 지원하며 검색 결과에서 일치하는 섹션으로 바로 이동할 수 있습니다.

******

### 빌드 및 검증

******

두 변형을 빌드하고 JVM 테스트를 실행하며 APK 검사로 동적으로 생성된 콘텐츠 메타데이터, 계약 메타데이터, 끊어진 링크, 단일 universal APK, `lib/*.so` 페이로드 부재 및 라이선스를 검증합니다:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

게시 가능한 Release APK 검증에는 Git에서 제외된 `sign.properties` 파일도 필요합니다:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### 런타임 동작

******

플러그인에는 독립 실행형 인터페이스가 없습니다. AutoJs6는 필요할 때 플러그인을 검색하고 검증한 뒤 전용 WebView 자산 로더를 통해 플러그인 AssetManager에서 문서를 직접 제공합니다. 플러그인 교체 또는 비활성화는 호스트가 감지합니다.

******

### 릴리스 기록

******

# v6.8.29

###### 2026/10/20

* `기능` Node.js/Bun/Worker의 Java 콜백, 하위 클래스 생성 및 JAR/DEX 로드로 Promise 반환값, 부모 클래스 호출 및 실행 종료 정리 지원

# v6.8.28

###### 2026/10/20

* `기능` Node.js/Bun/Worker의 Java/Android 상호 운용으로 공개 생성자와 멤버, 배열, 정확한 long 값, 명시적 오버로드 및 앱 Context 핸들 지원

# v6.8.27

###### 2026/10/19

* `기능` AutoJs6 스크립트의 스트리밍 Shell API, shell.spawn 및 shizuku.spawn이 반환하는 ShellProcess, Auto.js Pro 호환 파이프 Shell 및 $shell.setDefaultOptions 포함

##### 더 많은 릴리스 기록

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-ko.md)

******

### 라이선스

******

AutoJs6-Documentation에서 가져온 문서는 Apache-2.0입니다. Node.js 문서 템플릿, 스타일 및 파생 콘텐츠는 medium-zoom, docsify-copy-code 및 dnt-helper와 함께 MIT입니다. SHJS는 GPL-3.0입니다. Lato는 OFL-1.1입니다.

각 APK의 `assets/licenses/docs/`에는 저작자 표시 요약과 Apache-2.0, GPL-3.0, MIT 및 OFL-1.1 전문이 포함됩니다.

******

### 리소스 구조

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/normalize_offline_docs.py
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

`strings.xml`에는 현지화된 플러그인 설명이 포함됩니다; `plugin_instruction.md`에는 호스트에서 표시하는 사용 설명이 포함됩니다. `.python/normalize_offline_docs.py`는 생성된 오프라인 문서를 변경하지 않고 검증합니다. README와 CHANGELOG는 `.python/generate_markdown.py`가 JSON 소스에서 생성하며 완전한 CHANGELOG는 `app/src/main/assets/doc/`에 출력됩니다.

******

### 링크

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
