<template>
    <div class="parentContainer">
        <h1>DynamicSlot: </h1>
        <input type="text" v-model="dynamicName">
        <DynamicChild>
            <!--  슬롯 이름을 동적으로 설정 -->
            <template #[dynamicName]> 
                {{ dynamicName }}
            </template>

        </DynamicChild>
    </div>
</template>

<script setup>
import {ref} from 'vue';
import DynamicChild from './DynamicChild.vue';

const dynamicName = ref('');
</script>

<style lang="scss" scoped>
  .parentContainer {
        display: flex;
        align-items: center;
        flex-direction: column;
        border: 1px solid black;
    }
</style>