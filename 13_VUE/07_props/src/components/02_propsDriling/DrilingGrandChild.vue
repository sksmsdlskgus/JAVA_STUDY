<template>
    <h3> GrantChild: {{ injectCount }}</h3>
    <button @click="injectCount++">GrandChild가 증가(Parent것 수정)</button>
</template>

<script setup>
import { inject } from 'vue';

const injectCount = inject('count');

</script>

<style scoped>

</style>