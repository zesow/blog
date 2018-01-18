// 슬라이더 함수입니다. 제이쿼리를 이용하였습니다.

$('.slider').each(function() {
  // 슬라이드의 갯수만큼 아래의 익명함수를 반복합니다.

  var $this   = $(this);
  var $group  = $this.find('.slide-group'); // 슬라이더를 하나로 묶은 객체를 가져옵니다.
  var $slides = $this.find('.slide');       // 각각의 슬라이드들 입니다.
  var currentIndex = 0;                     // 슬라이드의 인덱스.
  var timeout;                              // 슬라이드 넘기는 시간 할당할 변수입니다.


// 함수1. 한번 이동하는 방법입니다. 가장 핵심이 되는 함수입니다.
  function move(newIndex) {
    var animateLeft, slideLeft;

    advance();
    // 다음 사진을 가리키게 합니다.


    if (newIndex > currentIndex) {
      slideLeft = '100%';
      animateLeft = '-100%';
    } else {
      slideLeft = '-100%';
      animateLeft = '100%';
    }

    // eq함수 : 인덱스로 객체 가리키는 함수입니다.
    $slides.eq(newIndex).css( {left: slideLeft, display: 'block'} );

    // animate 함수 : css 속성값을 조정하여 움직이는 효과를 줍니다.
    $group.animate( {left: animateLeft}, function() {
      $slides.eq(currentIndex).css( {display: 'none'} );
      $slides.eq(newIndex).css( {left: 0} );
      $group.css( {left: 0} );
      currentIndex = newIndex;
    });
  }

// 함수2. 3초에 한 번씩 인덱스가 변화해서 다음 슬라이드를 가리키게 하는 함수입니다.
  function advance() {
    clearTimeout(timeout);
    timeout = setTimeout(function() {
      if (currentIndex < ($slides.length - 1)) {
        move(currentIndex + 1);
      } else {
        move(0);
      }
    }, 3000);
  }

  advance();


});
