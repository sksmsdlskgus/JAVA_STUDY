<template>
<h1>{{ props.readValue }}</h1>
자식의 readValue: <input type="text" v-model="props.readValue">
</template>

<script setup>
import { defineProps } from 'vue';
const props = defineProps({
    readValue: String
}) // 이렇게 수정안대 ㅅㄱ 
</script>

<style scoped>

</style>