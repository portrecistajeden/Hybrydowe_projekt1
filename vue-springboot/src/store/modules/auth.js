import axios from 'axios';
const state={
    status:'',
    token:localStorage.getItem('token')||''
}

const getters={
    isLoggedIn: state => !!state.token,
    authStatus: state => state.status,
}

const actions ={
    login({commit},user){
         axios.post('http://localhost:8080/authenticate', user)
         .then(result=>{
             console.log(result.data),
             commit('REFRESH'),
             localStorage.setItem('token', result.data)
             
            }
        )
        
    },

    getUserID({commit},user){
        axios.post('http://127.0.0.1:8080/userid', user)
        .then(result=>{
            console.log(result.data),
            commit('REFRESH')
             localStorage.setItem('idUser', result.data)
            
           }
       )
       
   },

    logout(){
           
            localStorage.removeItem('token')
           // this.store.state.isLoggedIn =null
    }

    
}


//modyfikacje stanu
const mutations={
    auth_request(state){
        state.status = 'loading'
      },
      auth_error(state){
        state.status = 'error'
      },
      logout(state){
        state.status = ''
        state.token = ''
      },
}


//export
export default{
    state,
    getters,
    actions,
    mutations
}