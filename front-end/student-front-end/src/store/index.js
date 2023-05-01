import { createStore } from 'vuex'
const TOKEN_KEY = "SCHOOL_USER"
const store  = createStore({
    state:{
        user:null,
        // get websocket message
        webSocketMsg:''
    },
    mutations:{
        setUser(state,data){
            state.user = data;
            window.localStorage.setItem(TOKEN_KEY,JSON.stringify(state.user))
        },
        // set websocket message
        SET_WS_MSG: (state, msg) =>{
            state.webSocketMsg = msg
        },
    },
});

export default store;

