import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    proxy: {
      '/api': {
        // target: 'http://localhost:7777',

        /* 프론트에서 CORS처리를 하고자 하는 경우(프론트 프로젝트가 컨테이너가 아닌 상태) */
        // target: 'http://localhost:8055',

        /* docker-compose 및 docker network를 활용해 'springboot-app'이라는 이름으로 통신할 경우(프론트 프로젝트가 컨테이너인 경우) */
        /* 백엔드 컨테이너 내부에서 동작하는 포트 번호를 작성해야 한다.(8055:7777) */
        target: 'http://springboot-app:7777',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  }
})