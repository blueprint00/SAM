google.charts.load('current', {
    'packages': ['corechart']
});
google.charts.setOnLoadCallback(drawVisualization);

function drawVisualization() {
    var data = google.visualization.arrayToDataTable([
        ['Year', 'C/C++', 'Java', 'JavaScript', 'PHP', 'HTML5', 'OBject-C', 'Visual 계열', 'python', '기타'],
        ['2017', 90703, 121432, 53655, 17278, 3902, 9839, 26524, 5891, 7237],
    ]);
    var options = {
        title: '소프트웨어 전문 인력 현황',
        vAxis: {
            title: 'People'
        },
        hAxis: {
            title: 'Languages'
        },
        seriesType: 'bars',
            colors: ['#e90c35', '#f5002d', '#dc183c', '#be354d', '#93626b', '#b83d54', '#d02544', '#9f5663', '#ab495b']


    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_kosis'));
    chart.draw(data, options);
}



google.charts.load('current', {
    'packages': ['corechart']
});
google.charts.setOnLoadCallback(drawVisualization1);

function drawVisualization1() {
    var data = google.visualization.arrayToDataTable([
        ['수준', '상', '중', '하', { role: 'annotation' }],
        ['C', 10, 24, 20, ''],
        ['C++', 16, 22, 23, ''],
        ['Java', 28, 19, 29, '']
    ]);

    var options = {
        width: 600,
        height: 400,
        legend: { position: 'top', maxLines: 3 },
        bar: { groupWidth: '75%' },
        isStacked: 'percent'
    };
    var chart = new google.visualization.BarChart(document.getElementById('chart_lang'));
    chart.draw(data, options);
}

$(document).ready(function() {
    $("#fullpage").fullpage({
        anchors: ["Book0", "Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7", "Book8", "slide1"],
        menu: "#topMenu",
        loopHorizontal: true
            /*페이지 무한 루프 (회전) 방지
                       /*
                       autoScrolling: true,
                       scrollHorizontally: true, // you might not need this
                       controlArrows: true,
                       verticalCentered: false,
                       loopHorizontal: false,
                       dragAndMove: true,
                       slidesNavigation: true,
                       */
    });


    $('#lang').click(() => {
        console.log("Hello World!");
        $.fn.fullpage.moveTo('Book1', 1);
    });

    $('#proj').click(() => {
        console.log("Hello World!");
        $.fn.fullpage.moveTo('Book2', 1);
    });

    $('#intern').click(() => {
        console.log("Hello World!");
        $.fn.fullpage.moveTo('Book3', 1);
    });
    $('#edu').click(() => {
        console.log("Hello World!");
        $.fn.fullpage.moveTo('Book4', 1);
    });
    $('#test').click(() => {
        console.log("Hello World!");
        $.fn.fullpage.moveTo('Book5', 1);
    });
    $('#goal').click(() => {
        console.log("Hello World!");
        $.fn.fullpage.moveTo('Book7', 1);
    });


    var langs = [

        { value: '4D', data: '4D' },
        { value: 'Ada', data: 'Ada' },
        { value: 'ABAP', data: 'ABAP' },
        { value: 'HTML/CSS', data: 'HTML/CSS' },
        { value: 'Javascript', data: 'Javascript' },
        { value: 'Java', data: 'Java' },
        { value: 'Jsp', data: 'Jsp' },
        { value: 'Julia', data: 'Julia' },
        { value: 'BASIC', data: 'BASIC' },
        { value: 'C#', data: 'C#' },
        { value: 'C++', data: 'C++' },
        { value: 'D', data: 'D' },
        { value: 'Dart', data: 'Dart' },
        { value: 'F#', data: 'F#' },
        { value: 'Forth', data: 'Forth' },
        { value: 'Factor', data: 'Foctor' },
        { value: 'Go', data: 'Go' },
        { value: 'Haskell', data: 'Haskell' },
        { value: 'ML', data: 'ML' },
        { value: 'MATLAB', data: 'MATLAB' },
        { value: 'Objective-C', data: 'Objective-C' },
        { value: 'Rust', data: 'Rust' },
        { value: 'Ruby', data: 'Ruby' },
        { value: 'Pascal', data: 'Pascal' },
        { value: 'Prolog', data: 'Prolog' },
        { value: 'COBOL', data: 'COBOL' },
        { value: 'LISP', data: 'LISP' },
        { value: 'Lua', data: 'Lua' },
        { value: 'Perl', data: 'Perl' },
        { value: 'PHP', data: 'PHP' },
        { value: 'R', data: 'R' },
        { value: 'Groovy', data: 'Groovy' },
        { value: 'Scala', data: 'Scala' },
        { value: 'occam', data: 'occam' },
        { value: 'Swift', data: 'Swift' }

    ];

    var subjects = [
        /*
        { value: '20세기디자인과문화', data: '20세기디자인과문화' },
        { value: '21세기기업의인재상', data: '21세기기업의인재상' },
        { value: '21세기외교전쟁', data: '21세기외교전쟁' },
        { value: '2D디자인', data: '2D디자인' },
        { value: '3D디자인', data: '3D디자인' },
        { value: '3D모델링과애니메이션1', data: '3D모델링과애니메이션1' },
        { value: '4차산업혁명의이해', data: '4차산업혁명의이해' },
        { value: 'C#프로그래밍', data: 'C#프로그래밍' },
        { value: 'C++프로그래밍', data: 'C++프로그래밍' },
        { value: 'Capstone디자인(산학협력프로젝트)', data: 'Capstone디자인(산학협력프로젝트)' },
        { value: 'Capstone디자인설계', data: 'Capstone디자인설계' },
        { value: 'CEO특강', data: 'CEO특강' },
        { value: 'C언어응용과데이터구조', data: 'C언어응용과데이터구조' },
        { value: 'C프로그래밍', data: 'C프로그래밍' },
        { value: 'C프로그래밍및실습', data: 'C프로그래밍및실습' },
        { value: 'English Composition 1', data: 'English Composition 1' },
        { value: 'English Composition 2', data: 'English Composition 2' },
        { value: 'English Composition 3', data: 'English Composition 3' },
        { value: 'English Composition 4', data: 'English Composition 4' },
        { value: 'English for Professional Purposes 1', data: 'English for Professional Purposes 1' },
        { value: 'English for Professional Purposes 2', data: 'English for Professional Purposes 2' },
        { value: 'English Listening', data: 'English Listening' },
        { value: 'English Listening B', data: 'English Listening B' },
        { value: 'English Listening Practice 1', data: 'English Listening Practice 1' },
        { value: 'English Listening Practice 2', data: 'English Listening Practice 2' },
        { value: 'English Reading', data: 'English Reading' },
        { value: 'English Reading B', data: 'English Reading B' },
        { value: 'English Reading Practice 1', data: 'English Reading Practice 1' },
        { value: 'English Speaking Strategies(O) 1', data: 'English Speaking Strategies(O) 1' },
        { value: 'English Speaking Strategies(O) 2', data: 'English Speaking Strategies(O) 2' },
        { value: 'English Speaking Strategies(TS) 1', data: 'English Speaking Strategies(TS) 1' },
        { value: 'English Speaking Strategies(TS) 2', data: 'English Speaking Strategies(TS) 2' },
        { value: 'English Writing 1', data: 'English Writing 1' },
        { value: 'English Writing 2', data: 'English Writing 2' },
        { value: 'ES-3D애니메이션SW의활용', data: 'ES-3D애니메이션SW의활용' },
        { value: 'ES-3D프린팅의실무와활용', data: 'ES-3D프린팅의실무와활용' },
        { value: 'ES-디지털다큐멘터리', data: 'ES-디지털다큐멘터리' },
        { value: 'ES-디지털사운드디자인', data: 'ES-디지털사운드디자인' },
        { value: 'ES-디지털스토리텔링', data: 'ES-디지털스토리텔링' },
        { value: 'ES-디지털영상의합성과편집', data: 'ES-디지털영상의합성과편집' },
        { value: 'ES-모션그래픽스디자인', data: 'ES-모션그래픽스디자인' },
        { value: 'ES-문화예술과ICT', data: 'ES-문화예술과ICT' },
        { value: 'ES-미디어퍼포먼스프로젝트', data: 'ES-미디어퍼포먼스프로젝트' },
        { value: 'ES-미래기술과엔터테인먼트', data: 'ES-미래기술과엔터테인먼트' },
        { value: 'ES-비주얼프로그래밍', data: 'ES-비주얼프로그래밍' },
        { value: 'ES-빅데이터시각화', data: 'ES-빅데이터시각화' },
        { value: 'ES-엔터테인먼트SW미디어프로젝트', data: 'ES-엔터테인먼트SW미디어프로젝트' },
        { value: 'ES-영상처리소프트웨어', data: 'ES-영상처리소프트웨어' },
        { value: 'ES-웨어러블컴퓨터디자인', data: 'ES-웨어러블컴퓨터디자인' },
        { value: 'ES-인터렉티브미디어프로젝트', data: 'ES-인터렉티브미디어프로젝트' },
        { value: 'ES-인턴쉽실무1', data: 'ES-인턴쉽실무1' },
        { value: 'ES-인턴쉽실무2', data: 'ES-인턴쉽실무2' },
        { value: 'ES-창업을위한디지털패션디자인', data: 'ES-창업을위한디지털패션디자인' },
        { value: 'ES-콜라보레이션 크리에이티브', data: 'ES-콜라보레이션 크리에이티브' },
        { value: 'ES-콜로키움', data: 'ES-콜로키움' },
        { value: 'ESL', data: 'ESL' },
        { value: 'EU의정치경제와사회', data: 'EU의정치경제와사회' },
        { value: 'GIS및실습', data: 'GIS및실습' },
        { value: 'GMSW-EFL과빅데이터', data: 'GMSW-EFL과빅데이터' },
        { value: 'GMSW-IT기술영작문(기초)', data: 'GMSW-IT기술영작문(기초)' },
        { value: 'GMSW-IT기술영작문(심화)', data: 'GMSW-IT기술영작문(심화)' },
        { value: 'GMSW-IT기술을활용한로컬라이제이션', data: 'GMSW-IT기술을활용한로컬라이제이션' },
        { value: 'GMSW-NLE영상편집', data: 'GMSW-NLE영상편집' },
        { value: 'GMSW-미디어네트워크분석', data: 'GMSW-미디어네트워크분석' },
        { value: 'GMSW-미디어빅데이터분석', data: 'GMSW-미디어빅데이터분석' },
        { value: 'GMSW-빅데이터와영어텍스트마이닝', data: 'GMSW-빅데이터와영어텍스트마이닝' },
        { value: 'GMSW-영상프로덕션', data: 'GMSW-영상프로덕션' },
        { value: 'GMSW-자연어처리와프로그래밍언어', data: 'GMSW-자연어처리와프로그래밍언어' },
        { value: 'HCI개론', data: 'HCI개론' },
        { value: 'HCI와커뮤니케이션', data: 'HCI와커뮤니케이션' },
        { value: 'Hospitality경영통계원론', data: 'Hostpitality경영통계원론' },
        { value: 'Hospitality인적자원관리', data: 'Hostpitality인적자원관리' },
        { value: 'Hospitality전략경영론', data: 'Hostpitality전략경영론' },
        { value: 'Hospitality주류학', data: 'Hostpitality주류학' },
        { value: 'ICT인턴십4', data: 'ICT인턴십4' },
        { value: 'Intensive English', data: 'Intensive English' },
        { value: 'Intensive English 3', data: 'Intensive English 3' },
        { value: 'Intensive English 4', data: 'Intensive English 4' },
        { value: 'IoT (사물인터넷) 특론', data: 'IoT (사물인터넷) 특론' },
        { value: 'IT-패션융합디자인', data: 'IT-패션융합디자인' },
        { value: 'ITIL', data: 'ITIL' },
        { value: 'JAVA와데이터구조', data: 'JAVA와데이터구조' },
        { value: 'JAVA프로그래밍', data: 'JAVA프로그래밍' },
        { value: 'Job Hunting Skills', data: 'Job Hunting Skills' },
        { value: 'K-MOOC:4차산업혁명과사물인터넷입문', data: 'K-MOOC:4차산업혁명과사물인터넷입문' },
        { value: 'K-MOOC:게임인공지능', data: 'K-MOOC:게임인공지능' },
        { value: 'K-MOOC:모빌리티디자인방법론', data: 'K-MOOC:모빌리티디자인방법론' },
        { value: 'K-MOOC:범죄행동의심리학', data: 'K-MOOC:범죄행동의심리학' },
        { value: 'K-MOOC:알기쉬운드론항법제어', data: 'K-MOOC:알기쉬운드론항법제어' },
        { value: 'K-MOOC:웨어러블컴퓨터디자인', data: 'K-MOOC:웨어러블컴퓨터디자인' },
        { value: 'K-MOOC:정보보호와보안의기초', data: 'K-MOOC:정보보호와보안의기초' },
        { value: 'K-MOOC:창업의첫걸음', data: 'K-MOOC:창업의첫걸음' },
        { value: 'K-MOOC:콘텐츠산업의비즈니스전략', data: 'K-MOOC:콘텐츠산업의비즈니스전략' },
        { value: 'K-MOOC:파이썬을이용한빅데이터분석', data: 'K-MOOC:파이썬을이용한빅데이터분석' },
        { value: 'K-Pop Dance 1', data: 'K-Pop Dance 1' },
        { value: 'K-Pop Dance 2', data: 'K-Pop Dance 2' },
        { value: 'K-Pop Music 1', data: 'K-Pop Music 1' },
        { value: 'K-Pop Music 2', data: 'K-Pop Music 2' },
        { value: 'Korean Politics', data: 'Korean Politics' },
        { value: 'MATLAB프로그래밍', data: 'MATLAB프로그래밍' },
        { value: 'OOA&UML&Java', data: 'OOA&UML&Java' },
        { value: 'PR실무론', data: 'PR실무론' },
        { value: 'PR작문법', data: 'PR작문법' },
        { value: 'Relations between North and South Korea', data: 'Relations between North and South Korea' },
        { value: 'Role Play English', data: 'Role Play English' },
        { value: 'SHP고전강좌:Reading Intellectus 1', data: 'SHP고전강좌:Reading Intellectus 1' },
        { value: 'SHP고전강좌:Reading Intellectus 2', data: 'SHP고전강좌:Reading Intellectus 2' },
        { value: 'SHP고전강좌:Writing Intellectus 1', data: 'SHP고전강좌:Writing Intellectus 1' },
        { value: 'SM-디지털영상의합성과편집', data: 'SM-디지털영상의합성과편집' },
        { value: 'SM-소셜HCI', data: 'SM-소셜HCI' },
        { value: 'SM-소셜미디어개론', data: 'SM-소셜미디어개론' },
        { value: 'SM-소셜미디어기초프로그래밍', data: 'SM-소셜미디어기초프로그래밍' },
        { value: 'SM-소셜미디어마케팅', data: 'SM-소셜미디어마케팅' },
        { value: 'SM-소셜미디어분석', data: 'SM-소셜미디어분석' },
        { value: 'SM-소셜미디어서비스기획', data: 'SM-소셜미디어서비스기획' },
        { value: 'SM-소셜미디어운영전략', data: 'SM-소셜미디어운영전략' },
        { value: 'SM-소셜미디어프로젝트', data: 'SM-소셜미디어프로젝트' },
        { value: 'SM-소셜웹프로그래밍', data: 'SM-소셜웹프로그래밍' },
        { value: 'SM-소셜인텔리전스', data: 'SM-소셜인텔리전스' },
        { value: 'SM-소프트웨어상품혁신론', data: 'SM-소프트웨어상품혁신론' },
        { value: 'STEAM으로접근한디지털미디어아트', data: 'STEAM으로접근한디지털미디어아트' },
        { value: 'SW설계기초(산학프로젝트입문)', data: 'SW설계기초(산학프로젝트입문)' },
        { value: 'Technical Writing기초', data: 'Technical Writing기초' },
        { value: 'Technical Writing기초2', data: 'Technical Writing기초2' },
        { value: 'TOEIC R/C', data: 'TOEIC R/C' },
        { value: 'U-사회와프라이버시', data: 'U-사회와프라이버시' },
        { value: 'UCC(디지털동영상)기획,제작,편집및활용', data: 'UCC(디지털동영상)기획,제작,편집및활용' },
        { value: 'Unix프로그래밍', data: 'Unix프로그래밍' },
        { value: 'VHDL프로그래밍', data: 'VHDL프로그래밍' },
        { value: 'VJ제작', data: 'VJ제작' },
        { value: 'XML프로그래밍', data: 'XML프로그래밍' },
        { value: '가족스트레스와대처', data: '가족스트레스와대처' },
        { value: '가족학', data: '가족학' },
        { value: '가치투자입문', data: '가치투자입문' },
        */
        { value: '2D디자인', data: '2D디자인' },
        { value: '3D디자인', data: '3D디자인' },
        { value: 'C#프로그래밍', data: 'C#프로그래밍' },
        { value: 'C++프로그래밍', data: 'C++프로그래밍' },
        { value: 'Capstone디자인(산학협력프로젝트)', data: 'Capstone디자인(산학협력프로젝트)' },
        { value: 'Capstone디자인설계', data: 'Capstone디자인설계' },
        { value: 'C언어응용과데이터구조', data: 'C언어응용과데이터구조' },
        { value: 'C프로그래밍', data: 'C프로그래밍' },
        { value: 'C프로그래밍및실습', data: 'C프로그래밍및실습' },
        { value: 'ES-엔터테인먼트SW미디어프로젝트', data: 'ES-엔터테인먼트SW미디어프로젝트' },
        { value: 'HCI개론', data: 'HCI개론' },
        { value: 'ICT인턴십4', data: 'ICT인턴십4' },
        { value: 'IoT (사물인터넷) 특론', data: 'IoT (사물인터넷) 특론' },
        { value: 'JAVA와데이터구조', data: 'JAVA와데이터구조' },
        { value: 'JAVA프로그래밍', data: 'JAVA프로그래밍' },
        { value: 'K-MOOC:파이썬을이용한빅데이터분석', data: 'K-MOOC:파이썬을이용한빅데이터분석' },
        { value: 'SM-소셜미디어프로젝트', data: 'SM-소셜미디어프로젝트' },
        { value: 'SW설계기초(산학프로젝트입문)', data: 'SW설계기초(산학프로젝트입문)' },
        { value: 'Unix프로그래밍', data: 'Unix프로그래밍' },
        { value: 'VHDL프로그래밍', data: 'VHDL프로그래밍' },
        { value: 'XML프로그래밍', data: 'XML프로그래밍' },
        { value: '객체지향설계기술', data: '객체지향설계기술' },
        { value: '게임기획', data: '게임기획' },
        { value: '게임이론세미나1', data: '게임이론세미나1' },
        { value: '게임이론세미나2', data: '게임이론세미나2' },
        { value: '게임프로그래밍', data: '게임프로그래밍' },
        { value: '고급C프로그래밍', data: '고급C프로그래밍' },
        { value: '고급C프로그래밍및실습', data: '고급C프로그래밍및실습' },
        { value: '고급데이터마이닝', data: '고급데이터마이닝' },
        { value: '고급머신비젼', data: '고급머신비젼' },
        { value: '고급인터넷응용', data: '고급인터넷응용' },
        { value: '공개키암호론', data: '공개키암호론' },
        { value: '공업역학', data: '공업역학' },
        { value: '공학설계기초', data: '공학설계기초' },
        { value: '공학설계기초(산학프로젝트입문)', data: '공학설계기초(산학프로젝트입문)' },
        { value: '공학설계입문', data: '공학설계입문' },
        { value: '기초렌더링', data: '기초렌더링' },
        { value: '기초창의설계', data: '기초창의설계' },
        { value: '기초프로그래밍설계', data: '기초프로그래밍설계' },
        { value: '내러티브워크샵', data: '내러티브워크샵' },
        { value: '네트워크보안', data: '네트워크보안' },
        { value: '네트워크프로그래밍', data: '네트워크프로그래밍' },
        { value: '네트워크해킹', data: '네트워크해킹' },
        { value: '닷넷프로그래밍', data: '닷넷프로그래밍' },
        { value: '데이터구조론', data: '데이터구조론' },
        { value: '데이터구조론과알고리즘', data: '데이터구조론과알고리즘' },
        { value: '데이터마이닝특론', data: '데이터마이닝특론' },
        { value: '데이터베이스', data: '데이터베이스' },
        { value: '데이터베이스기초', data: '데이터베이스기초' },
        { value: '데이터베이스및보안', data: '데이터베이스및보안' },
        { value: '데이터베이스실습', data: '데이터베이스실습' },
        { value: '데이터분석개론', data: '데이터분석개론' },
        { value: '동역학', data: '동역학' },
        { value: '디자인사', data: '디자인사' },
        { value: '디자인인모션1', data: '디자인인모션1' },
        { value: '디지털논리회로', data: '디지털논리회로' },
        { value: '디지털드로잉', data: '디지털드로잉' },
        { value: '디지털디자인', data: '디지털디자인' },
        { value: '디지털사운드', data: '디지털사운드' },
        { value: '디지털시스템이해', data: '디지털시스테밍해' },
        { value: '디지털신호처리', data: '디지털드로잉신호처리' },
        { value: '디지털영상처리개론', data: '디지털영상처리개론' },
        { value: '디지털제작도구연구', data: '디지털제작도구연구' },
        { value: '디지털콘텐츠학과연구실인턴쉽1', data: '디지털콘텐츠학과연구실인턴쉽1' },
        { value: '디지털콘텐츠학과연구실인턴쉽2', data: '디지털콘텐츠학과연구실인턴쉽2' },
        { value: '디지털콘텐츠학과연구실인턴쉽1', data: '디지털콘텐츠학과연구실인턴쉽1' },
        { value: '라이프드로잉', data: '라이프드로잉' },
        { value: '리눅스의기초및실습', data: '리눅스의기초및실습' },
        { value: '리버스엔지니어링', data: '리버스엔지니어링' },
        { value: '마이크로컴퓨터', data: '마이크로컴퓨터' },
        { value: '만화기초1', data: '만화기초1' },
        { value: '만화기초2', data: '만화기초2' },
        { value: '만화제작', data: '만화제작' },
        { value: '멀티미디어', data: '멀티미디어' },
        { value: '멀티미디어프로그래밍', data: '멀티미디어프로그래밍' },
        { value: '멀티코어프로그래밍', data: '멀티코어프로그래밍' },
        { value: '모델링&텍스처링', data: '모델링&텍스처링' },
        { value: '모바일시스템보안', data: '모바일시스템보안' },
        { value: '모바일프로그래밍', data: '모바일프로그래밍' },
        { value: '무선통신', data: '무선통신' },
        { value: '문제해결및실습:C++', data: '문제해결및실습:C++' },
        { value: '문제해결및실습:JAVA', data: '문제해결및실습:JAVA' },
        { value: '문화콘텐츠개론', data: '문화콘텐츠개론' },
        { value: '발상과표현', data: '발상과표현' },
        { value: '문제해결및실습:C++', data: '문제해결및실습:C++' },
        { value: '보안경진대회트레이닝', data: '보안경진대회트레이닝' },
        { value: '보안경진대회트레이닝2', data: '보안경진대회트레이닝2' },
        { value: '보안프로그래밍', data: '보안프로그래밍' },
        { value: '비주얼커뮤니케이션디자인1', data: '비주얼커뮤니케이션디자인1' },
        { value: '비주얼커뮤니케이션디자인2', data: '비주얼커뮤니케이션디자인2' },
        { value: '비쥬얼씽킹', data: '비쥬얼씽킹' },
        { value: '빅데이터', data: '빅데이터' },
        { value: '사이버전개론', data: '사이버전개론' },
        { value: '사이버전쟁과테러리즘', data: '사이버전쟁과테러리즘' },
        { value: '선형대수', data: '선형대수' },
        { value: '선형대수및프로그래밍', data: '선형대수및프로그래밍' },
        { value: '소프트웨어공학', data: '소프트웨어공학' },
        { value: '소프트웨어공학', data: '소프트웨어공학과보안' },
        { value: '소프트웨어교육1', data: '소프트웨어교육1' },
        { value: '소프트웨어분석과보안코딩', data: '소프트웨어분석과보안코딩' },
        { value: '소프트웨어특강1', data: '소프트웨어특강1' },
        { value: '소프트웨어특강2', data: '소프트웨어특강2' },
        { value: '수치해석', data: '수치해석' },
        { value: '수학3', data: '수학3' },
        { value: '수학4', data: '수학4' },
        { value: '시스템감사', data: '시스템감사' },
        { value: '시스템관리및보안', data: '시스템관리및보안' },
        { value: '시스템보안실무', data: '시스템보안실무' },
        { value: '시스템보안특론', data: '시스템보안특론' },
        { value: '시스템프로그래밍', data: '시스템프로그래밍' },
        { value: '시스템해킹', data: '시스템해킹' },
        { value: '신경망개론', data: '신경망개론' },
        { value: '신호및시스템', data: '신호및시스템' },
        { value: '심화프로그래밍설계', data: '심화프로그래밍설계' },
        { value: '악성코드분석', data: '악성코드분석' },
        { value: '알고리즘', data: '알고리즘' },
        { value: '알고리즘및실습', data: '알고리즘및실습' },
        { value: '암호수학', data: '암호수학' },
        { value: '애니메이션기초1', data: '애니메이션기초1' },
        { value: '애니메이션기초2', data: '애니메이션기초2' },
        { value: '애니메이션액팅1', data: '애니메이션액팅1' },
        { value: '어셈블리어', data: '어셈블리어' },
        { value: '영상처리', data: '영상처리' },
        { value: '영상편집및제작', data: '영상편집및제작' },
        { value: '오픈소스SW개론', data: '오픈소스SW개론' },
        { value: '오픈소스SW공학', data: '오픈소스SW공학' },
        { value: '오픈소스SW설계', data: '오픈소스SW설계' },
        { value: '요구공학', data: '요구공학' },
        { value: '운영체제', data: '운영체제' },
        { value: '웹프로그래밍', data: '웹프로그래밍' },
        { value: '웹프로그래밍&웹퍼블리싱', data: '웹프로그래밍&웹퍼블리싱' },
        { value: '웹프로그래밍설계', data: '웹프로그래밍설계' },
        { value: '웹해킹과보안', data: '웹해킹과보안' },
        { value: '윈도우즈프로그래밍', data: '윈도우즈 프로그래밍' },
        { value: '유닉스', data: '유닉스' },
        { value: '응용암호론', data: '응용암호론' },
        { value: '이산수학', data: '이산수학' },
        { value: '이산수학및프로그래밍', data: '이산수학및프로그래밍' },
        { value: '인공지능', data: '인공지능' },
        { value: '인공지능특론', data: '인공지능특론' },
        { value: '인터넷보안', data: '인터넷보안' },
        { value: '인터넷응용특론', data: '인터넷응용특론' },
        { value: '인터렉티브디자인', data: '인터렉티브디자인' },
        { value: '일반물리및시뮬레이션', data: '일반물리및시뮬레이션' },
        { value: '일본의정보산업', data: '일본의정보산업' },
        { value: '임베디드시스템', data: '임베디드시스템' },
        { value: '임베디드시스템및보안', data: '임베디드시스템및보안' },
        { value: '임베디드시스템보안', data: '임베디드시스템보안' },
        { value: '자기주도창의전공I', data: '자기주도창의전공I' },
        { value: '자기주도창의전공II', data: '자기주도창의전공II' },
        { value: '자기주도창의전공III', data: '자기주도창의전공III' },
        { value: '자기주도창의전공IV', data: '자기주도창의전공IV' },
        { value: '자료구조및실습', data: '자료구조및실습' },
        { value: '자바프로그래밍', data: '자바프로그래밍' },
        { value: '전공관련기업연수1', data: '전공관련기업연수1' },
        { value: '전공관련기업연수2', data: '전공관련기업연수2' },
        { value: '전공관련기업연수4', data: '전공관련기업연수4' },
        { value: '전공인턴십1', data: '전공인턴십1' },
        { value: '전공인턴십10', data: '전공인턴십10' },
        { value: '전공인턴십12', data: '전공인턴십12' },
        { value: '전공인턴십7', data: '전공인턴십7' },
        { value: '전공인턴십8', data: '전공인턴십8' },
        { value: '전기회로', data: '전기회로' },
        { value: '전력IT특론', data: '전력IT특론' },
        { value: '전산특강1', data: '전산특강1' },
        { value: '전산특강2', data: '전산특강2' },
        { value: '정보검색', data: '정보검색' },
        { value: '정보기술', data: '정보기술' },
        { value: '정보기술의관리', data: '정보기술의관리' },
        { value: '정보보호개론', data: '정보보호개론' },
        { value: '정보보호와보안의기초', data: '정보보호와보안의기초' },
        { value: '정보보호특강1', data: '정보보호특강1' },
        { value: '정보보호특강2', data: '정보보호특강2' },
        { value: '정보보호특론', data: '정보보호특론' },
        { value: '정수론', data: '정수론' },
        { value: '졸업연구및발표1', data: '졸업연구및발표1' },
        { value: '졸업연구및발표2', data: '졸업연구및발표2' },
        { value: '졸업연구및진로1', data: '졸업연구및진로1' },
        { value: '졸업연구및진로2', data: '졸업연구및진로2' },
        { value: '지능정보시스템', data: '지능정보시스템' },
        { value: '지능형시스템', data: '지능형시스템' },
        { value: '창의융합노마드', data: '창의융합노마드' },
        { value: '창의융합노마드(P/NP)', data: '창의융합노마드(P/NP)' },
        { value: '취약점과보안코딩의이해', data: '취약점과보안코딩의이해' },
        { value: '취약점및위험분석', data: '취약점및위험분석' },
        { value: '침입탐지및대응', data: '침입탐지및대응' },
        { value: '컨셉디자인', data: '컨셉디자인' },
        { value: '컴파일러', data: '컴파일러' },
        { value: '컴퓨터구조', data: '컴퓨터구조' },
        { value: '컴퓨터구조3', data: '컴퓨터구조3' },
        { value: '컴퓨터구조론', data: '컴퓨터구조론' },
        { value: '컴퓨터구조론1', data: '컴퓨터구조론1' },
        { value: '컴퓨터그래픽스', data: '컴퓨터그래픽스' },
        { value: '컴퓨터그래픽스1', data: '컴퓨터그래픽스1' },
        { value: '컴퓨터그래픽스2', data: '컴퓨터그래픽스2' },
        { value: '컴퓨터네트워크', data: '컴퓨터네트워크' },
        { value: '컴퓨터비전시스템', data: '컴퓨터비전시스템' },
        { value: '컴퓨터애니메이션특론', data: '컴퓨터애니메이션특론' },
        { value: '코딩이론', data: '코딩이론' },
        { value: '콘텐츠기획1', data: '콘텐츠기획1' },
        { value: '콘텐츠저작설계', data: '콘텐츠저작설계' },
        { value: '타이포그래피', data: '타이포그래피' },
        { value: '통신시스템', data: '통신시스템' },
        { value: '특허와창업', data: '특허와창업' },
        { value: '파이썬프로그래밍', data: '파이썬프로그래밍' },
        { value: '패턴인식', data: '패턴인식' },
        { value: '패턴인식개론', data: '패턴인식개론' },
        { value: '프로그래밍1', data: '프로그래밍1' },
        { value: '프로그래밍2', data: '프로그래밍2' },
        { value: '프로그래밍과언어', data: '프로그래밍과언어' },
        { value: '프로그래밍과언어3', data: '프로그래밍과언어3' },
        { value: '프로그래밍과언어4', data: '프로그래밍과언어4' },
        { value: '프로그래밍언어', data: '프로그래밍언어' },
        { value: '프로그래밍언어의개념', data: '프로그래밍언어의개념' },
        { value: '프로그래밍언어이론', data: '프로그래밍어이론' },
        { value: '프로덕트디자인1', data: '프로덕트디자인1' },
        { value: '프로덕트디자인2', data: '프로덕트디자인2' },
        { value: '해부학', data: '해부학' },
        { value: '확률과통계', data: '확률과통계' },
        { value: '확률및통계', data: '확률및통계' },
        { value: '확률통계및프로그래밍', data: '확률통계및프로그래밍' },
    ];

    $('#searchbox').autocomplete({
        lookup: langs
    });
    $('#searchbox1').autocomplete({
        lookup: langs
    });
    $('#searchbox2').autocomplete({
        lookup: langs
    });
    $('#searchbox3').autocomplete({
        lookup: langs
    });

    $('#searchbox4').autocomplete({
        lookup: subjects
    });

});