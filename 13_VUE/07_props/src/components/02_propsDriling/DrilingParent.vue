<template>
    <div class="container">
        <h1> Parents: {{ count }}</h1>
        <Child/>

    </div>
</template>


<!-- 
Props Driling:
상위 컴포넌트에서 하위 컴포넌트로 데이터를 전달하는 과정에서 중간에 여러 컴포넌트를 거쳐가는 경우를 말한다.
이렇게 여러 컴포넌트를 거쳐 props를 전달하는 것은 코드를 복잡하게 만들고 유지보수를 어렵게 한다. 
vue에서는 필요한 부모 컴포넌트 하위 컴포넌트 중에 필요시 inject하여 어디서든 사용할수 있도록 provide를 제공한다.
(다만, readonly를 고려헤야하ㅣ고 어떤 하위 컴포넌트가 ionject하는지 알기 쉽지 않다.)
-->
<script setup>
import { provide,ref,readonly } from 'vue';
import Child from './DrilingChild.vue';

const count = ref(1);
provide('count', readonly(count)); 
// 읽기모드로 하려면 리드온니 달아줘

</script>

<style scoped>

</style>