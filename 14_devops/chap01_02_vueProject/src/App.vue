<!-- vbase-3-setup -->
<template>
  <div class="plus">
    <h1>덧셈 기능 만들기</h1>
    <label>num1: </label><input type="text" v-model="num1">&nbsp;
    <label>num2: </label><input type="text" v-model="num2">&nbsp;
    <button @click="sendPlus">더하기</button>
    <hr>
    <p>`{{ num1 }} + {{ num2 }} = {{ result }}`</p>
  </div>
</template>

<script setup>
  import { ref } from 'vue';

  const num1 = ref(0);
  const num2 = ref(0);
  const result = ref(0);

  const sendPlus = async() => {
    // const response = await fetch(`http://localhost:7777/plus?num1=${num1.value}&num2=${num2.value}`);
    // const response = await fetch(`http://localhost:5173/api/plus?num1=${num1.value}&num2=${num2.value}`);

    /* 8055컨테이너(8055:7777로 된 백엔드 서버 컨테이너)로 요청 시(백엔드에서 CORS 처리를 했을 경우) */
    // const response = await fetch(`http://localhost:8055/plus?num1=${num1.value}&num2=${num2.value}`);

    /* 프론트에서 CORS처리를 하고자 하는 경우(프론트 프로젝트가 컨테이너가 아닌 상태) */
    // const response = await fetch(`http://localhost:5173/api/plus?num1=${num1.value}&num2=${num2.value}`);

    /* 프론트에서 CORS처리를 하고자 하는 경우(프론트 프로젝트가 컨테이너인 상태) */
    const response = await fetch(`http://localhost:8011/api/plus?num1=${num1.value}&num2=${num2.value}`);

    const data = await response.json();
    result.value = data.sum;
  }



</script>

<style scoped>
  .plus {
    text-align: center;
  }
</style>