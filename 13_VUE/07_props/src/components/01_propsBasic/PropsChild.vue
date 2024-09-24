<template>
       <h3>전달 받은 props: {{ props.message }}</h3>  <!-- 객체 형식으로 받아야함  -->
</template>

<script setup>
import {defineProps} from 'vue';
/*
defineProps 함수를 활용해 String형의 message props를 받아 props 변수에 담는다. 
(slot과 달리 부모로부터 받으면 객체이다.)
(또한, slot과 달리 변수에 담아두고 계속 사용할 수 있다.)

props는 무조건 자식에서는 read only로 수정되게 하면 안된다. 
*/

const props = defineProps({
    message: String
})

</script>

<style scoped>
</style>