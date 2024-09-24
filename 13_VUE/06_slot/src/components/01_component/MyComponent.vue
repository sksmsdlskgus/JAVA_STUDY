<template>
    <div>
        <h1>MyComponent</h1>
        <p>{{onMounted}}</p>
    </div>
</template>

<script setup>
 import {onMounted} from 'vue';

// export default{
//     setup(){
        onMounted(async() => {
            console.log("Hello world!");
        })

    // }
// }

</script>

<style scoped>

</style>