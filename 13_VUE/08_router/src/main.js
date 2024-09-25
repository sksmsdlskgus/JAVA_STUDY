
import { createApp } from 'vue'
import App from './App.vue'
// 라우터는 반드시 use를 통해 등록해주어야한다.
// import router from './router/01_router.js';
import router2 from './router/02_nestedRout'

// createApp(App).user(router).mount('#app') //라우팅 정보를 app.vue에게 알린다는 의미
const app = createApp(App);
// app.use(router);
app.use(router2);
app.mount('#app');
