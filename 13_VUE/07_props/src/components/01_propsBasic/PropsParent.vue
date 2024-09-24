<template>
    <div>
        props 입력 : <input type="text" v-model="message">
        <PropsChild :message="message"/> <!--변수명은 맞춰주는게 좋음-->
<!-- 다른 이름으로 전달할 수 있지만 일반적으로 같은 이름을 사용한다. (:props이름)-->
   <DarkMode @toggle="toggleDarkMode"/>
   
   </div>
</template>

<script setup>
import {ref} from 'vue';
import PropsChild from './PropsChild.vue';
import DarkMode from './DarkMode.vue';

const message = ref('hello');

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