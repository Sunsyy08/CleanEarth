package com.example.cleanearth.data

import kotlin.random.Random
import com.example.cleanearth.R

// ───── 데이터 클래스 ─────
data class ReformIdea(
    val id: String,
    val name: String,
    val subtitle: String,
    val steps: List<String>,
    val imageRes: Int
    )

/*
 *  카테고리별 10 개씩, 총 60 개의 리폼 아이디어를 하드코딩했습니다.
 *  필요 시 imageRes, videoUrl 등을 추가해 확장할 수 있습니다.
 */

// ───── 판지 (Cardboard) ─────
val cardboardIdeas = listOf(
    ReformIdea("C01", "노트북 스탠드", "경사각이 있는 인체공학 스탠드", listOf(
        "골판지를 노트북보다 2 cm 크게 자른다.",
        "2 cm 간격으로 접는 선을 만들고 계단형으로 접어 지지대를 만든다.",
        "앞단 모서리를 45°로 깎아 손목 부담을 줄인다.",
        "풀로 접합 후 무거운 책으로 1 시간 압착.",
        "투명 래커를 뿌려 습기에 강하게 마감한다."),
        R.drawable.notebookstand_paper),
    ReformIdea("C02", "미니 책꽂이", "데스크톱용 A5 사이즈 보관함", listOf(
        "상자 두 개를 반으로 잘라 ㄷ자 형태로 붙인다.",
        "옆판에 삼각 보강판을 덧대어 뒤틀림을 방지한다.",
        "아크릴 물감으로 원하는 색상을 도포한다.",
        "바니시로 표면 코팅 후 24 시간 건조한다."),
        R.drawable.frame_paper),
    ReformIdea("C03", "케이블 홀더", "책상 모서리에 붙이는 정리대", listOf(
        "두꺼운 판지를 3 × 10 cm로 자른다.",
        "상단에 1 cm 폭 U자 홈을 4개 파낸다.",
        "뒷면에 양면테이프 부착 후 책상 모서리에 고정한다."),
        R.drawable.cableholder_paper),
    ReformIdea("C04", "묘목 발아 트레이", "12 칸 씨앗 스타터", listOf(
        "달걀판 같은 칸막이 판지를 잘라 3 × 4칸 배열한다.",
        "칸마다 흙과 씨앗을 투입, 물 분무 후 햇빛에 둔다.",
        "발아 후 판지를 통째로 화분 흙에 묻어 자연 분해한다."),
        R.drawable.seedling_paper),
    ReformIdea("C05", "서랍 칸막이", "맞춤형 정리 인서트", listOf(
        "서랍 내부 치수를 재고 판지를 길이·높이에 맞춰 자른다.",
        "I자, T자 모양 칸막이를 끼워 맞추기 위해 슬롯을 절개한다.",
        "배치 후 움직이지 않도록 양면테이프를 점착한다."),
        R.drawable.drawers_paper),
    ReformIdea("C06", "벽걸이 액자", "A4 출력물을 위한 라이트 프레임", listOf(
        "판지 2장을 A4보다 2 cm 크게 잘라 테두리 절개한다.",
        "투명 OHP 필름을 앞판 뒤에 테이핑한다.",
        "사진을 끼우고 뒷판을 붙인 뒤 상단에 실 고리를 부착한다."),
        R.drawable.bookcase_paper),
    ReformIdea("C07", "캣 스크래처", "층층이 쌓는 발톱갈이", listOf(
        "같은 크기 사각 판지를 40장 자른다.",
        "중앙에 1 cm 구멍을 뚫고 나사·볼트로 압축 결합한다.",
        "캣닢 스프레이를 뿌려 고양이를 유도한다."),
        R.drawable.scratcher_paper),
    ReformIdea("C08", "신발 선반", "2단 경량 랙", listOf(
        "박스 2개를 눕혀 겹치고 측면에 L자 지지대를 추가한다.",
        "앞쪽 가장자리에 3 cm 가드를 부착한다.",
        "아크릴 페인트 후 방수 바니시로 마감한다."),
        R.drawable.shoerack_paper),
    ReformIdea("C09", "램프 갓", "은은한 무드등", listOf(
        "원통형 판지를 원하는 높이로 자른다.",
        "핀으로 작은 구멍을 패턴 형태로 뚫는다.",
        "LED 전구 위에 씌우고 열 방출 여부를 확인한다."),
        R.drawable.lamp_paper),
    ReformIdea("C10", "접이식 보관 상자", "사용 안 할 땐 납작하게", listOf(
        "판지 3장을 +자형으로 접착 후 옆면을 상자 형태로 올린다.",
        "모서리에 벨크로를 붙여 접었다 펼 수 있게 한다.",
        "겉면에 라벨을 붙여 내용물을 구분한다."),
        R.drawable.box_paper)
)

// ───── 유리 (Glass) ─────
val glassIdeas = listOf(
    ReformIdea("G01", "마크라메 행잉 화병", "유리병 + 면 로프 인테리어", listOf(
        "유리병 입구에 면 로프를 매듭 방식으로 고정한다.",
        "아래로 2→4→8 줄로 나누어 매듭한다.",
        "바닥에서 다시 모아 매듭 후 여분 로프를 컷한다.",
        "천장 고리에 걸어 플랜터를 완성한다."),
        R.drawable.vase_glass),
    ReformIdea("G02", "테라리움", "다육·이끼 미니 정원", listOf(
        "병 안에 자갈 1 cm, 활성탄 0.5 cm, 토양 2 cm 순서로 층을 쌓는다.",
        "다육식물·이끼를 배치하고 분무기로 물을 준다.",
        "뚜껑을 열어두거나 구멍을 뚫어 환기한다."),
        R.drawable.terrarium_glass),
    ReformIdea("G03", "태양광 정원등", "재활용 자 + 태양광 LED", listOf(
        "태양광 LED 모듈을 분리 후 뚜껑 중앙에 장착한다.",
        "실리콘으로 씰링 후 화단에 거꾸로 꽂아 자동 충전·점등한다."),
        R.drawable.gardenlight_glass),
    ReformIdea("G04", "오일 램프", "캠핑 분위기 조명", listOf(
        "마개에 심지 홀더와 면 심지를 통과시킨다.",
        "병에 파라핀 오일을 채우고 심지 길이를 조절한다.",
        "점화 후 밝기를 조정한다."),
        R.drawable.oillamp_glass),
    ReformIdea("G05", "면봉 디스펜서", "욕실 정리 소품", listOf(
        "병 입구를 자석 뚜껑으로 교체한다.",
        "전면에 라벨을 부착하고 면봉을 세로로 담는다."),
        R.drawable.cottonswab_glass),
    ReformIdea("G06", "스파이스 셰이커", "DIY 소금·후추통", listOf(
        "뚜껑에 2 mm 구멍 6개를 송곳으로 뚫는다.",
        "내부에 실리콘 가스켓을 넣어 습기를 차단한다.",
        "허브·스파이스를 채워 조리대에 배치한다."),
        R.drawable.shaker_glass),
    ReformIdea("G07", "스노우 글로브", "겨울 감성 장식", listOf(
        "뚜껑 안에 피규어를 에폭시로 접착한다.",
        "병에 증류수 90 % + 글리세린 10 % + 글리터를 넣는다.",
        "뚜껑을 단단히 닫고 실리콘으로 마감한다."),
        R.drawable.snow_glass),
    ReformIdea("G08", "샌드 아트 보틀", "컬러 모래층 인테리어", listOf(
        "색 모래를 깔때기로 층층이 붓는다.",
        "나무 꼬치로 벽면을 눌러 패턴을 연출한다.",
        "뚜껑에 접착제를 발라 모래를 고정한다."),
        R.drawable.sandbottle_glass),
    ReformIdea("G09", "티라이트 홀더", "안마카페 무드", listOf(
        "병 윗부분을 유리 절단기로 절단 후 사포로 정리한다.",
        "바닥에 모래층을 깔고 티라이트를 삽입한다.",
        "외부에 아크릴 페인트로 패턴을 그린다."),
        R.drawable.tlight_glass),
    ReformIdea("G10", "액체 비누 디스펜서", "펌프 달린 업사이클", listOf(
        "펌프 캡을 병 입구 나사선에 맞춘다.",
        "비누 원액을 채우고 펌프 길이를 잘라 장착한다."),
        R.drawable.soapdispenser_glass)
)

// ───── 금속 (Metal) ─────
val metalIdeas = listOf(
    ReformIdea("M01", "바람 종", "틴캔 + 체인 풍경", listOf(
        "빈 캔 바닥 중앙에 구멍을 뚫어 체인을 연결한다.",
        "캔 표면을 페인트 후 투명 래커로 코팅한다.",
        "체인 끝에 너트를 달아 울림을 강화한다."),
        R.drawable.bell_can),
    ReformIdea("M02", "미니 캠핑 스토브", "알루미늄 캔 로켓", listOf(
        "음료캔 두 개를 절단·끼워 복층 구조를 만든다.",
        "측면 공기흡입 홀 16개, 상단 버너 홀 8개를 천공한다.",
        "알코올 연료를 주입 후 점화한다."),
        R.drawable.stove_can),
    ReformIdea("M03", "데스크 펜꽂이", "사무실 빈티지 소품", listOf(
        "캔 윗부분을 따낸 뒤 사포로 정리한다.",
        "스트라이프 패턴 후 스프레이로 도장한다.",
        "내부에 투명 코팅제를 분사한다."),
        R.drawable.penholder_can),
    ReformIdea("M04", "허브 플랜터", "주방 창가 미니 화분", listOf(
        "캔 바닥에 배수구 4개를 뚫는다.",
        "자갈 1 cm + 배양토 5 cm를 채우고 허브를 이식한다.",
        "양옆에 철사 손잡이를 달아 이동성을 높인다."),
        R.drawable.planter_can),
    ReformIdea("M05", "랜턴", "구멍 패턴 그림자 조명", listOf(
        "캔 측면에 별·달 모양으로 펀치 작업을 한다.",
        "내부에 LED 캔들을 삽입하고 걸이 고리를 부착한다."),
        R.drawable.flashlight_can),
    ReformIdea("M06", "스마트폰 스피커", "음량 증폭 메가폰", listOf(
        "캔 측면에 폰 두께만큼 세로 슬롯을 절개한다.",
        "캔 내부를 깔때기형으로 펼쳐 소리 방향성을 확보한다."),
        R.drawable.speaker_can),
    ReformIdea("M07", "멀티툴 홀더", "벽걸이 자석 보드", listOf(
        "캔 뚜껑을 잘라 네오디뮴 자석 3개를 부착한다.",
        "벽에 설치하여 작은 공구를 부착해 보관한다."),
        R.drawable.magnetic_can),
    ReformIdea("M08", "쿠키 커터", "알루미늄 스트립", listOf(
        "캔 링을 분리해 원하는 모양으로 구부린다.",
        "양끝을 에폭시로 접착 후 24 시간 건조한다."),
        R.drawable.cookie_can),
    ReformIdea("M09", "새집 지붕", "나무 새집 방수 캡", listOf(
        "큰 통조림 캔을 반으로 절단 후 펼쳐 판금한다.",
        "리벳으로 목재 지붕 위에 고정한다."),
        R.drawable.bird_can),
    ReformIdea("M10", "네일 부품 정리함", "자석 뚜껑 보관", listOf(
        "참치캔 5개를 나무판에 글루건으로 계단 배열한다.",
        "뚜껑마다 자석을 부착해 탈착형으로 변환한다."),
        R.drawable.canhanger_can)
)

// ───── 비닐/비닐봉지 (Plastic Bag) ─────
val plasticBagIdeas = listOf(
    ReformIdea("PB01", "퓨즈드 비닐 토트백", "다리미로 만든 업사이클 가방", listOf(
        "비닐봉지 손잡이·바닥을 제거하고 6~8겹 적층한다.",
        "파치먼트지 사이에 끼워 스팀 없는 다리미 중·저온으로 10 초씩 눌러 융착시트를 만든다.",
        "시트 두 장을 같은 크기로 재단(A4 이상 추천).",
        "옆·바닥을 2.5 cm 시접으로 재봉한다.",
        "융착 시트 스트립을 접어 손잡이를 만들고 상단에 상침한다."
    ), R.drawable.totebag_plasticbag),

    ReformIdea("PB02", "플라른 크로셰 마켓백", "비닐실로 뜨는 장바구니", listOf(
        "비닐을 2.5 cm 폭 링으로 잘라 체인 방식으로 연결해 플라른을 만든다.",
        "8 mm 후크, 사슬 40코로 원형 메쉬 몸통을 25 cm 정도 뜬다.",
        "입구에서 5단 감폭 후 사슬 60코로 양쪽 손잡이를 만든다.",
        "실 마무리 후 스팀 블로킹으로 형태를 잡는다."
    ), R.drawable.marketbag_plasticbag),

    ReformIdea("PB03", "플라른 슬리핑매트", "노숙인·캠핑용 매트", listOf(
        "4 cm 폭 링 700장으로 플라른을 만든다.",
        "12 mm 후크, 사슬 42\"(약 107 cm) 길이를 뜬다.",
        "한길긴뜨기로 6′(약 183 cm) 길이까지 직진한다.",
        "플라른 사슬 100코 스트랩을 달아 휴대성을 높인다.",
        "물세탁 후 자연 건조한다."
    ), R.drawable.sleepingbad_plasticbag),

    ReformIdea("PB04", "퓨즈드 비닐 지퍼 파우치", "생활방수 멀티 파우치", listOf(
        "융착 시트 2장을 20×12 cm로 재단한다.",
        "9″(23 cm) 지퍼를 안면 맞대어 상침한다.",
        "지퍼를 연 상태로 옆·바닥을 재봉한다.",
        "파우치를 뒤집어 모서리를 정리한다.",
        "지퍼 고리를 달아 완성도를 높인다."
    ), R.drawable.pouch_plasticbag),

    ReformIdea("PB05", "비닐 컬러 비즈", "열수축 DIY 구슬", listOf(
        "얇게 융착한 비닐을 1×8 cm 삼각형으로 자른다.",
        "이쑤시개에 단단히 말아 고정한다.",
        "160 °C 오븐에서 4 분 가열해 수축시킨다.",
        "식힌 뒤 투명 매니큐어로 코팅해 광택을 준다.",
        "기름종이 위에서 완전히 건조한다."
    ), R.drawable.beads_plasticbag),

    ReformIdea("PB06", "비닐 폼폼 장식", "선물·파티용 퍼프", listOf(
        "10×25 cm 스트립을 아코디언 접기한다.",
        "중앙을 철사나 실로 단단히 묶는다.",
        "양 끝을 V컷 형태로 자른다.",
        "겹겹을 하나씩 벌려 둥글게 퍼트린다.",
        "리본·모빌 등 장식에 활용한다."
    ), R.drawable.foamfoam_plasticbag),

    ReformIdea("PB07", "비닐 트위스트 로프", "견고한 다용도 끈", listOf(
        "비닐 스트립 두 가닥을 준비한다.",
        "각 가닥을 같은 방향으로 비틀어 장력을 준다.",
        "두 가닥을 반대 방향으로 꼬아 로프를 만든다.",
        "새 스트립을 5 cm 겹쳐 이어 꼬기를 반복한다.",
        "끝단을 라이터 열로 살짝 녹여 마감한다."
    ), R.drawable.rope_plasticbag),

    ReformIdea("PB08", "비닐 브레이드 바구니", "업사이클 수납함", listOf(
        "비닐을 4 cm 스트립으로 잘라 3가닥씩 꽉 땋아 끈을 만든다.",
        "땋은 끈을 코일처럼 돌돌 말아 바닥을 형성한다.",
        "위로 올리며 손바늘로 솔기를 박음질한다.",
        "림은 스트립을 반 접어 휘프 스티치로 감싼다.",
        "손잡이를 추가해 실용성을 높인다."
    ), R.drawable.basket_plasticbag),

    ReformIdea("PB09", "비닐 충전 데코 쿠션", "러스트프리 야외 쿠션", listOf(
        "비닐을 5 cm 조각으로 잘라 소음을 줄인다.",
        "면 또는 방수 원단으로 커버를 재봉하고 한쪽을 남긴다.",
        "조각 비닐과 허브 팟을 가득 채워 탄성을 맞춘다.",
        "남은 개구를 상침해 마감한다.",
        "가볍게 두드려 형태를 정리한다."
    ), R.drawable.cushion_plasticbag),

    ReformIdea("PB10", "비닐 레인 파카", "응급 우비·비상용", listOf(
        "비닐봉지를 펼쳐 앞·뒤·소매·후드 패턴을 그린다.",
        "가위로 재단 후 베이킹페이퍼를 덮고 다리미로 솔기 융착한다.",
        "몸판과 소매를 이어 붙인 뒤, 후드를 결합한다.",
        "지퍼·스냅 대신 접착식 벨크로를 부착해 여밈을 만든다.",
        "통풍 구멍을 소매·옆솔기에 천공해 쾌적성을 높인다."
    ), R.drawable.raincoat_plasticbag)
)



// ───── 종이 (Paper) ─────
val paperIdeas = listOf(
    ReformIdea("P01", "씨앗 종이 카드", "심을 수 있는 엽서", listOf(
        "폐지 조각을 물에 불려 믹서기로 갈아 펄프를 만든다.",
        "체망 위에 얇게 펴고 물기를 제거한다.",
        "젖은 상태에서 꽃씨를 고루 뿌리고 건조한다."),
        R.drawable.papercard_paper),
    ReformIdea("P02", "파피에 마쉐 볼", "가벼운 과일 바구니", listOf(
        "신문지를 3 cm 스트립으로 찢어 풀에 적신다.",
        "풍선 위에 4겹 이상 겹쳐 붙이고 24 시간 건조한다.",
        "풍선을 제거 후 아크릴 페인트로 도장한다."),
        R.drawable.basket_paper),
    ReformIdea("P03", "오리가미 램프 갓", "접는 종이 조명", listOf(
        "A3 두꺼운 종이에 접기 패턴을 그린다.",
        "산·골 접기를 반복해 육면체 형태를 완성한다.",
        "LED 전구에 씌우고 고리 실로 고정한다."),
        R.drawable.foldlamp_paper),
    ReformIdea("P04", "수제 노트", "실 제본 빈티지 노트", listOf(
        "A4 폐지를 반 접어 중철 위치에 송곳으로 3개 구멍을 낸다.",
        "실과 바늘로 재봉하고 크래프트지 표지를 덧붙인다."),
        R.drawable.note_paper),
    ReformIdea("P05", "선물 봉투", "맞춤형 기프트 백", listOf(
        "컬러 종이를 선물 크기보다 3 cm 크게 잘라 접는다.",
        "바닥 삼각 접기 후 본드를 바른다.",
        "상단을 펀칭 후 끈을 끼운다."),
        R.drawable.envelope_paper),
    ReformIdea("P06", "종이 완충재", "택배 포장 충격 흡수", listOf(
        "종이를 슈레이더로 잘게 잘라 큰 봉투에 담는다.",
        "박스 빈 공간에 채워 충격을 완충한다."),
        R.drawable.buffermaterial_paper),
    ReformIdea("P07", "종이 구슬 목걸이", "컬러 매거진 업사이클", listOf(
        "삼각형으로 자른 잡지 페이지를 꼬아 구슬을 만든다.",
        "바니시를 발라 단단히 경화 후 실에 꿰어서 목걸이를 만든다."),
        R.drawable.necklace_paper),
    ReformIdea("P08", "펄프 연필", "종이심 & 그래파이트", listOf(
        "종이 펄프에 흑연 파우더 10 %를 넣어 반죽한다.",
        "실리콘 몰드에 눌러 넣고 탈수·건조한다.",
        "아크릴 페인트로 외부를 코팅한다."),
        R.drawable.pencil_paper),
    ReformIdea("P09", "친환경 콘페티", "생분해 파티 아이템", listOf(
        "색종이를 펀치로 찍어낸다.",
        "전분 접착제를 살짝 뿌려 정전기를 방지한다.",
        "행사 후 퇴비화가 가능하다."),
        R.drawable.confetti_paper),
    ReformIdea("P10", "월아트 콜라주", "잡지·포스터 데코", listOf(
        "마음에 드는 사진을 오려 레이아웃을 배치한다.",
        "캔버스 보드에 스틱풀로 부착 후 바니시로 코팅한다."),
        R.drawable.wallart_paper)
)

// ───── 플라스틱 (Plastic) ─────
val plasticIdeas = listOf(
    ReformIdea("PL01", "자동 급수 화분", "뒤집은 병 속 물 공급", listOf(
        "물병 뚜껑에 2 mm 구멍 3개를 뚫는다.",
        "물을 채운 뒤 거꾸로 화분 흙에 꽂아 천천히 스며들게 한다.",
        "3–5일 간격으로 물을 보충한다.",
         ),R.drawable.flowerpot_plastic),
    ReformIdea("PL02", "수직 정원 타워", "페트병 5단 연결", listOf(
        "병마다 측면을 U자형 절단해 식재 구멍을 만든다.",
        "바닥·뚜껑에 8 mm 구멍을 뚫고 케이블 타이로 수직 연결한다.",
        "맨 윗병에 물을 주면 아래로 순차적으로 공급된다.",
        ),R.drawable.gardentower_plastic),
    ReformIdea("PL03", "폰 사운드 앰프", "병 목을 이용한 증폭", listOf(
        "페트병 목 부분을 자르고 옆면에 폰 슬롯을 절개한다.",
        "병 끝을 깔때기처럼 오므려 스피커 방향성을 확보한다.",
        ),R.drawable.soapcase_plastic),
    ReformIdea("PL04", "새 모이통", "뚜껑 조임 방식 급식", listOf(
        "병 측면에 3 cm 원형 구멍 2개를 뚫는다.",
        "구멍 아래에 나무 막대를 글루건으로 고정해 perch를 만든다.",
        "씨앗을 채우고 나무에 매단다.",
        ),R.drawable.birdfeeders_plastic),
    ReformIdea("PL05", "스토리지 스쿱", "쌀·사료 퍼내기 삽", listOf(
        "물병 윗부분 1/3을 대각선으로 잘라 손잡이를 포함한다.",
        "모서리를 사포로 다듬어 안전하게 처리한다.",
        ),R.drawable.scoop_plastic),
    ReformIdea("PL06", "데스크 서랍", "미니 부품 보관함", listOf(
        "직육면체 세제통 3개를 서랍 본체로 사용한다.",
        "외부 박스 내부에 레일테이프를 부착한다.",
        "앞면에 라벨과 손잡이 고리를 부착한다.",
        ),R.drawable.drawer_plastic),
    ReformIdea("PL07", "가글 컵 홀더", "체결형 칫솔 스탠드", listOf(
        "작은 음료병을 절반 절단해 컵 형태를 만든다.",
        "병목 링을 이용해 칫솔 손잡이 고정 슬롯을 제작한다.",
        ),R.drawable.cup_plastic),
    ReformIdea("PL08", "드립 관수 깔때기", "정원 점적 급수", listOf(
        "병에 1 mm 핀홀을 10개 뚫어 물 배출 속도를 조절한다.",
        "흙에 반쯤 묻어 물이 뿌리로 직접 스며들게 한다.",
        ),R.drawable.funnel_plastic),
    ReformIdea("PL09", "여행 비누 케이스", "슬라이드형 잠금", listOf(
        "사각 주스병을 높이 4 cm로 절단한다.",
        "투명 비닐로 슬리브 덮개를 제작하고 탭을 만든다.",
        ),R.drawable.soapcase_plastic),
    ReformIdea("PL10", "LED 페어리 라이트 병", "분위기 조명", listOf(
        "와이어 미니 LED를 병 안에 감아 넣는다.",
        "뚜껑에 배터리 팩을 부착하고 스위치 구멍을 카빙한다.",
        "무드등으로 침실·캠핑에 활용한다.",
        ),R.drawable.lightbottle_plastic)
)

// ───── 최종 맵 & 헬퍼 ─────
val ideasByCategory: Map<String, List<ReformIdea>> = mapOf(
    "판지"       to cardboardIdeas,
    "잔"         to glassIdeas,
    "금속"       to metalIdeas,
    "비닐" to plasticBagIdeas,
    "종이"       to paperIdeas,
    "플라스틱"   to plasticIdeas
)

fun getRandomIdea(category: String): ReformIdea? =
    ideasByCategory[category]?.random()

fun getRandomIdeas(category: String, count: Int = 3): List<ReformIdea> =
    ideasByCategory[category]?.shuffled(Random(System.currentTimeMillis()))?.take(count) ?: emptyList()

