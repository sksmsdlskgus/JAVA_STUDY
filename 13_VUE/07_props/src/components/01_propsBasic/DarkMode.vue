<!-- 
부모로부터 전달된 이벤트(사용자 정의형)를 활용해 부모의 이벤트를 동작시켜 부모의 이벤트
핸들러 함수를 실행한다.
(자식 컴포넌트가 부모 컴포넌트로 발산(emit('해당 이벤트 이름'))) 
-->

<template>
<button @click="emit('toggle')">다크모드</button>
<!-- 자식이 부모를 호출하니까 버튼이 자식에 있어도 부모의 메소드가 호출되는 방식으로 가야함  -->
</template>

<script setup>
import { defineEmits } from 'vue';

/* 
부모로부터 물려받은 toggle이라는 이름의 이벤트를 호출할 수 있는 반환 받기 
(defineEmits를 활용해서 배열에 이벤트 이름을 작성)
*/
const emit = defineEmits(['toggle']);
</script>

<style lang="scss" scoped>

</style>