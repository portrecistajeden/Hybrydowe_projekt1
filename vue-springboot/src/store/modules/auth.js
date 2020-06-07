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
         axios.post('https://hybrydkoweapi.azurewebsites.net/authenticate', user)
         .then(result=>{
             console.log(result.data),
             commit('REFRESH'),
             localStorage.setItem('token', result.data)
             
            }
        )
        
    },

    getUserID({commit},user){
        axios.post('https://hybrydkoweapi.azurewebsites.net/userid', user)
        .then(result=>{
            console.log(result.data),
            commit('REFRESH')
             localStorage.setItem('idUser', result.data)
            
           }
       )
       
   },

    logout(){
           
            localStorage.removeItem('token')
            localStorage.removeItem('idUser')
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