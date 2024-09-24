<template>
   <div class="container">
    <h1>NamedSlot</h1>
    <NamedChild>
        <template v-slot:name>
            <h2>
                name: {{ obj.name }}
            </h2>
        </template>
        <template v-slot:founder>
            <p>
                founder: {{ obj.founder }}
            </p>
        </template>
        <template v-slot:img>
            <img :src="obj.img">
            <br>
        </template>
    </NamedChild>
   </div>
</template>

<script setup>
import NamedChild from "@/components/03_namedslot/NamedChild.vue";
import {reactive, ref} from 'vue';

const obj = reactive({
    name:"vue",
    founder:"Evan You",
    img:"https://images.ctfassets.net/s5uo95nf6njh/2fEr6ctL9FxPtOPhUcM4FA/773007e573bfa16aebdb736f767b45fa/evan-you-hero.jpg"
})

</script>

<style scoped>

.container {
        display: flex;
        flex-direction: column;
        align-items: center;
        border: 1px solid black;
    }
    img {
        width: 200px;
        height: 200px;
    }
</style>