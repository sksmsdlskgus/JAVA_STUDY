import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router';
import HomeView from '@/views/01_router/HomeView.vue';
import PathVariable from '@/views/01_router/PathVariable.vue';
import QueryString from '@/views/01_router/QueryString.vue';

const router = createRouter({ 
    // history: createWebHashHistory(), 
    history: createWebHistory(),  // 경로에 #이 안달립니다.
    // createWebHashHistory 와 createWebHistory 여기에 사용가능 
    routes: [ // 3개의 페이지가 되는것임 -> 이거의 뷰는 app에 안만들고 뷰폴더를 만들어서 안에다가 만듬 
        {
            path: '/',
            component: HomeView
        },
        {
            // pathvariable방식으로 라우팅을 할때는 받아줄 변수명을 작성한다.
            path: '/pathvariable/:id',
            component: PathVariable
        },
        {
            path: '/querystring',
            component: QueryString
        }
    ]
})

export default router;