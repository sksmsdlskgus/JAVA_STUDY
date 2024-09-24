<!-- vbase-3-setup -->

<!-- 
template:
vue는 사용자의 화면에 보여지는 부분을 내보낼 때 다음과같이 <template> 하위에 구성하여 작성한다.
template은 다른 엘리먼트 요소를 감싸주는 역할을 수행하여 사용자의 화면에 렌더링 될 때 제거된다. 
(하나의 컴포넌트가 화면에 어떻게 보여질지 컴포넌트 단위의 html이 작성된다고 볼 수 있다.)
-->
<template>

  <header>
    <p>Hello!</p>
      <MyComponent/>
      <hr>
  </header>
  <br>

      <main>
        <SlotParent/>
        <hr>
        <div>
          <NamedParent/>
        </div>
        <div>
          <DynamicParent/>
        </div>
      </main>
      
</template>

<!-- 
script setup:
해당 컴포넌트에 적용할 setup함수 안의내용 (반응형 변수/반응형 변수에 변화를 주는 함수/라이프 사이클 훅)을 작성하며 
view model의 개념을 작성하는 영역이다.
-->

<script setup>
  import MyComponent from './components/01_component/MyComponent.vue';
  import SlotParent from './components/02_slotintro/SlotParent.vue';
  // 자식을 임포트 해버리면 해당 데이터가 안뜬다 . 자식을 보여줘야 부모도 같이 보여지는 줄 알았는데 부모를 보여주면 자식을 보여주는것이군 
  import NamedParent from './components/03_namedslot/NamedParent.vue';
  import DynamicParent from './components/04_dynamicslot/DynamicParent.vue';
</script>


<!-- 
style scoped:
현재 컴포넌트에서만 적용되는 스타일을 작성한다. (범위 css(고유한 번호의 컴포넌틐에만 적용됨))
-->

<style scoped>

</style>