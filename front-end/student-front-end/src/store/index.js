
// import { createPinia } from 'pinia'

// import { createApp } from 'vue'
import { createStore } from 'vuex'
const TOKEN_KEY = "SCHOOL_USER"
const store  = createStore({
    state:{
        user:null,
    },
    mutations:{
        setUser(state,data){
            state.user = data;
            window.localStorage.setItem(TOKEN_KEY,JSON.stringify(state.user))
        },
    },
});

export default store;

