google.charts.load('current', {
    'packages': ['corechart']
});
google.charts.setOnLoadCallback(drawVisualization);

function drawVisualization() {
    var data = google.visualization.arrayToDataTable([
        ['Month', 'Bolivia', 'Ecuador', 'Madagascar', 'Papua New Guinea', 'Rwanda', 'Average'],
        ['2004/05', 165, 938, 522, 998, 450, 614.6],
        ['2005/06', 135, 1120, 599, 1268, 288, 682],
    ]);
    var options = {
        title: 'Monthly Coffee Production by Country',
        vAxis: {
            title: 'Cups'
        },
        hAxis: {
            title: 'Month'
        },
        seriesType: 'bars',
        series: {
            5: {
                type: 'line'
            }
        }
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_lang'));
    chart.draw(data, options);
}

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
        seriesType: 'bars'
            /*,
            series: {
                5: {
                    type: 'line'
                }
            }
            */
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_kosis'));
    chart.draw(data, options);
}

$(document).ready(function() {
    $("#fullpage").fullpage({
        anchors: ["Book0", "Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7", "Book8"],
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
    var langs = [
        { value: 'HTML/CSS', data: 'HTML/CSS' },
        { value: 'Javascript', data: 'Javascript' },
        { value: '베이직', data: '베이직' },
        { value: 'C#', data: 'C#' },
        { value: 'D', data: 'D' },
        { value: 'F#', data: 'F#' },
        { value: '루비', data: '루비' },
        { value: '파스칼', data: '파스칼' },
        { value: '프롤로그', data: '프롤로그' },
        { value: '코볼', data: '코볼' },
        { value: '리스프', data: '리스프' },
        { value: '펄', data: '펄' },
        { value: 'R', data: 'R' },
        { value: '그루비', data: '그루비' },
        { value: '스칼라', data: '스칼라' },
        { value: 'occam', data: 'occam' },
        { value: 'Swift', data: 'Swift' }
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


    /*
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
    });*/
});
/*Demo purposes only */
$(".hover").mouseleave(
    function() {
        $(this).removeClass("hover");
    }
);


// envelope animation
window.onload = function() {
    var tl = new TimelineLite({ delay: 1 }),
        firstBg = document.querySelectorAll('.text__first-bg'),
        word = document.querySelectorAll('.text__word');

    tl
        .to(firstBg, 0.2, { scaleX: 1 })
        .to(word, 0.1, { opacity: 1 }, "-=0.1")
        .to(firstBg, 0.2, { scaleX: 0 });

}