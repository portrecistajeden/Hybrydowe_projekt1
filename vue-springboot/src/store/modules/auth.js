import axios from 'axios';
const state={
    logged:false,
    //idLoggedUser:null
}

const getters={
    logged:state=>{
        return state.logged
    },
    idLoggedUser:state=>{
        return state.idLoggedUser
    }
}

const actions ={
    login({commit}, user){
         axios.post('http://localhost:8080/login', user)
         .then( result=>commit('USER',result.data.idUser) )
        
    }
}


//modyfikacje stanu
const mutations={
    USER(state,idUser){
        state.idLoggedUser=idUser
    },
}


//export
export default{
    state,
    getters,
    actions,
    mutations
}