<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>AutoJs6용 오프라인 문서 6.6.4 콘텐츠 플러그인</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
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

AutoJs6 Offline Documentation 플러그인은 전체 6.6.4 문서 사이트를 독립적으로 설치할 수 있는 콘텐츠 패키지로 제공합니다.

******

### 플러그인 계약

******

```text
applicationId=io.github.supermonster003.autojs6.plugin.offlinedocs
pluginId=offline-docs
engine=offline-docs
variant=6.6.4
contractVersion=1
requiredHostVersionCode=5240
contentVersion=6.8.0
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=181
totalBytes=10057274
contentSha256=da281f7e264406afaa12ff9969304cf361ab8b9db948a59cfd73c28108c7ba86
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=e6bded6c8d0dbeb688c26eec2b5a241a4664ecc4
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

# v6.8.0

###### 2026/08/21

* `개선` 플러그인의 versionName을 대상 AutoJs6 문서 버전과 일치시키고, 문서 동기화 성공 시 두 프로젝트의 build/versionCode를 각각 자동으로 1 증가
* `개선` 내장 AutoJs6 6.8.0 문서와 오프라인 검색 인덱스를 업데이트하여 YOLO 객체 탐지 Preview API, 정확한 공급자 설정, 모델 프로필, 결과 유형 및 안정적인 오류 코드 반영
* `개선` 내장 AI 참조 문서를 보완하여 플러그인 모델 검색, 공식/정확한 구성 요소 선택기, 다중 역할 메시지 기록, 생성 제어, 정확한 사용량 및 스트리밍 페이로드, 전체 라우팅 예제 반영
* `개선` 내장 AI 참조 문서와 오프라인 검색 색인을 확장하여 영구 `ai.session` Conversation API, 고정 세션 제어, 턴마다 새 프롬프트 하나만 전달하는 수명 주기 규칙, 기능 검색 및 명시적 리소스 해제 의미를 반영
* `개선` 내장 AI 참조 문서와 오프라인 검색 색인을 확장하여 `structuredJson`/`responseSchema` 기반 네이티브 JSON Schema 제약 출력, 영구 세션 고정 schema, JSON 텍스트 반환 및 실패 규칙을 반영
* `개선` 내장 AI 참조 문서와 오프라인 검색 색인을 확장하여 명시적 CPU/GPU/NPU backend profile, `ai.catalog` 기기 가용성과 안정적 사용 불가 사유, 영구 세션 고정 backend, GPU 호환성 제한 및 fallback 금지 계약을 반영
* `개선` 공개되지 않은 모든 AI 목록/구성 확인 API를 통합 `ai.catalog` 대상 디렉터리, `target` 정확 라우팅, 완전한 응답/세션 메타데이터, 폴백 없는 안정 오류로 직접 교체하고 온라인/오프라인 자산을 동기화

# v1.0.1

###### 2026/07/25

* `개선` 고정 콘텐츠 지문 기준을 현재 문서 자산에서 자동 생성되는 콘텐츠 메타데이터와 인벤토리로 대체하여 자산을 직접 업데이트할 수 있도록 변경
* `개선` AutoJs6 공식 Markdown 소스에서 오프라인 문서를 생성하고 동기화하여 온라인 및 오프라인 콘텐츠의 일관성 유지
* `개선` 내장 문서를 AutoJs6 API 참조 형식으로 통일하고, 현재 제품명, JavaScript 변수 선언, 로컬 타입 링크, 미완성 섹션 안내 및 ASCII 문장 부호를 표준화
* `개선` 제목과 본문을 대상으로 하는 전체 텍스트 검색 및 일치하는 섹션으로 바로 이동하는 기능으로 오프라인 문서 탐색 환경 개선

# v1.0.0

###### 2026/07/23

* `기능` 계약 버전 1 검색과 단일 universal APK를 제공하는 독립 AutoJs6 6.6.4 오프라인 문서 콘텐츠 플러그인 출시
* `기능` 161개 문서 파일, 현지화된 플러그인 메타데이터 및 완전한 Apache-2.0, GPL-3.0, MIT, OFL-1.1 고지 포함
* `개선` 정규 콘텐츠 지문, 계약 메타데이터, 알려진 끊어진 링크 기준, 단일 universal APK, `lib/*.so` 페이로드 부재 및 라이선스 자산을 위한 JVM 및 APK 검사 추가
* `개선` 바이트 단위 문서 콘텐츠의 정확한 AutoJs6 소스 커밋과 소스 경로 기록

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
