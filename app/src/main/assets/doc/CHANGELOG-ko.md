******

### 릴리스 기록

******

# v6.8.0

###### 2026/09/11

* `수정` 오프라인 문서 validator 가 공개 Node bridge method 이름 `callAutoJs` 를 이전 제품의 단독 이름으로 더 이상 오인하지 않습니다
* `개선` MediaInfo 참조와 오프라인 검색 인덱스를 동기화하고 기존 `read`와 버전이 지정된 `snapshot`의 경계, 플러그인 snapshot v1/v2 schema 협상, 경량 `capabilities`, 동적 v2 track 및 엔진 정보를 추가
* `개선` Pinyin 참조 문서와 오프라인 검색 인덱스를 동기화하고 호출 단위 `customDictionary` 발음 재정의, 완성된 `compare`/`compact`, 명시적 `pinyin` capability 가 있는 `autojs6:bridge.callAutoJs` 를 통한 Node.js 접근을 추가
* `개선` Image Quantization v4 참조와 오프라인 검색 색인을 동기화하여 구성 가능한 픽셀 및 작업 메모리 예산, 형식화된 리소스 한도 진단, 계산된 최대 메모리 지표, 명시적 요청 또는 스크립트 종료 시 취소를 추가
* `개선` 플러그인의 versionName을 대상 AutoJs6 문서 버전과 일치시키고, 문서 동기화 성공 시 두 프로젝트의 build/versionCode를 각각 자동으로 1 증가
* `개선` 내장 AutoJs6 6.8.0 문서와 오프라인 검색 인덱스를 업데이트하여 YOLO 객체 탐지 Preview API, 정확한 공급자 설정, 모델 프로필, 결과 유형 및 안정적인 오류 코드 반영
* `개선` 내장 AI 참조 문서를 보완하여 플러그인 모델 검색, 공식/정확한 구성 요소 선택기, 다중 역할 메시지 기록, 생성 제어, 정확한 사용량 및 스트리밍 페이로드, 전체 라우팅 예제 반영
* `개선` 내장 AI 참조 문서와 오프라인 검색 색인을 확장하여 영구 `ai.session` Conversation API, 고정 세션 제어, 턴마다 새 프롬프트 하나만 전달하는 수명 주기 규칙, 기능 검색 및 명시적 리소스 해제 의미를 반영
* `개선` 내장 AI 참조 문서와 오프라인 검색 색인을 확장하여 `structuredJson`/`responseSchema` 기반 네이티브 JSON Schema 제약 출력, 영구 세션 고정 schema, JSON 텍스트 반환 및 실패 규칙을 반영
* `개선` 내장 AI 참조 문서와 오프라인 검색 색인을 확장하여 명시적 CPU/GPU/NPU backend profile, `ai.catalog` 기기 가용성과 안정적 사용 불가 사유, 영구 세션 고정 backend, GPU 호환성 제한 및 fallback 금지 계약을 반영
* `개선` 공개되지 않은 모든 AI 목록/구성 확인 API를 통합 `ai.catalog` 대상 디렉터리, `target` 정확 라우팅, 완전한 응답/세션 메타데이터, 폴백 없는 안정 오류로 직접 교체하고 온라인/오프라인 자산을 동기화
* `개선` 내장 runtime 참조와 오프라인 검색 인덱스를 확장하여 검증된 mapping/seeds/usage/retrace metadata 내보내기를 위한 6개 `loadJarWithR8` 오버로드와 프로토콜 1.1 `retraceR8Stack` API, 출처 결합 및 fallback 없는 fail-closed 동작을 추가
* `개선` README 레이아웃과 Gradle 플랫폼 버전 관리 방식을 통일
* `개선` MediaInfo 참조 문서와 오프라인 검색에 streamNumber, countGet, infoKind 및 원본 경로 동작을 반영
* `개선` 빌드 시 의도하지 않은 네이티브 의존성을 거부하고 JSON 보고서 생성

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
