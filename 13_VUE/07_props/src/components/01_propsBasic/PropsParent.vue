<template>
    <div :class="{container:true, dark:darkState}">
        <!-- 아래 toggle을 자식이 호출하면 dark부분이 같이 달아준다는의미  -->
        props 입력 : <input type="text" v-model="message">
        <PropsChild :message="message"/> <!--변수명은 맞춰주는게 좋음-->
    <!-- 다른 이름으로 전달할 수 있지만 일반적으로 같은 이름을 사용한다. (:props이름)-->
  
    <!-- props는 아니지만 이벤트를 물려줄 수도있다. -->
    <DarkMode @toggle="toggleDarkMode"/>

   <!-- 사용자 정의형 토글 이벤트를 넘기는것 props는 아님 
    자식니 @뒤의 명을 호출하면 해당 메소드가 호출됨-->
  
    <!-- 자식 컴포넌트에서 직접 props를 수정해보기  -->
     부모의 readValue: <input type="text" v-model="readValue">
     <ReadProps :readValue="readValue"/>
  </div>
</template>

<script setup>
import {ref} from 'vue';
import PropsChild from './PropsChild.vue';
import DarkMode from './DarkMode.vue';
import ReadProps from './ReadProps.vue';

const message = ref('hello');
const darkState = ref(false);
const readValue = ref('Vue는 재밌을까');

function toggleDarkMode() {
    darkState.value =  !darkState.value;
}

</script>

<style scoped>

.container{
    border: 1px solid;
    display: flex;
    flex-direction: column;
    align-items: center;
}
.dark{
    background-color: black;
    color: white;
}

</style>