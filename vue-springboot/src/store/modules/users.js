import axios from 'axios';

const state={
    users:[],
    ref:0,
}

const getters={
    users: state=>{
        return state.users
    },

    ref:state=>{
        return state.ref
    }
    
}

//wywołuje axios'owe puknięcie
const actions={
    getUsers({commit}){
         axios.get('http://localhost:8080/users')
         .then(result=>commit('USERS',result.data))
           
    },

    deleteUser({commit},idUser){
         axios.delete('http://localhost:8080/users/'+idUser)
         .then(()=>commit('REF'))
    },

    addUser({commit},book){
         axios.post('http://localhost:8080/users',book)
         .then(()=>commit('REF'))
    },
    searchUser({commit},searchValue){
         axios.get('http://localhost:8080/users/username/'+searchValue)
        .then(result=>commit('USERS',result.data))
    }
}

//modyfikacje stanu
const mutations={
    USERS(state,users){
        state.users=users
    },
    REF(state){
        state.ref=++state.ref
    }
}


//export
export default{
    state,
    getters,
    actions,
    mutations
}