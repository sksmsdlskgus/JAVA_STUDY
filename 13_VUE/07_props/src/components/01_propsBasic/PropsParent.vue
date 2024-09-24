<template>
    <div>
        props 입력 : <input type="text" v-model="message">
    </div>
</template>

<script setup>
import {ref} from 'vue';
import PropsChild from './PropsChild.vue';

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