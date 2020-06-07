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
        const auth={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.get('https://hybrydkoweapi.azurewebsites.net/users',auth)
         .then(result=>commit('USERS',result.data))
           
    },

    deleteUser({commit},idUser){
        const auth1={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.delete('https://hybrydkoweapi.azurewebsites.net/users/'+idUser,auth1)
         .then(()=>commit('REF'))
    },

    addUser({commit},book){
        const auth2={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.post('https://hybrydkoweapi.azurewebsites.net/users',book,auth2)
         .then(()=>commit('REF'))
    },
    searchUser({commit},searchValue){
        const auth3={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.get('https://hybrydkoweapi.azurewebsites.net/users/username/'+searchValue,auth3)
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