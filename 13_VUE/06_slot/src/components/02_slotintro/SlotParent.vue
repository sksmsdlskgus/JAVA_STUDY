<template>
    <div class="parentContainer">
        <h1>Parent</h1>
        <Child>
            {{ slotData }}
        </Child>  
    </div>
</template>

<script setup>
import Child from "./Slotchild.vue";
import {ref} from 'vue';

const slotData = ref('hello data');
</script>

<style scoped>
    .parentContainer{
        display: flex;
        align-items: center;
        flex-direction: column;
        border: 1px soild black;
    }

</style>