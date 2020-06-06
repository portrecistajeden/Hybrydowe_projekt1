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
        //console.log(user)
        // return new Promise((resolve, reject)=>{
        //     commit('auth_request')
        //     axios({url:'http://localhost:8080/authenticate', data:user, method:'POST'})
        //     .then(result=>{
        //         const token=result.data
        //         localStorage.setItem('token', token)
        //         axios.defaults.headers.common['Authorization']=token
        //         resolve(result)
        //     })
        //     .catch(err=>{
        //         commit('auth_err')
        //         localStorage.removeItem('token')
        //         reject(err)
        //     })
               
        // })
         axios.post('http://localhost:8080/authenticate', user)
         .then(result=>{
             console.log(result.data),
             commit('REFRESH'),
             localStorage.setItem('token', result.data)
            }
        )
        
    },

    logout({commit}){
        return new Promise((resolve)=>{
            commit('logout')
            localStorage.removeItem('token')
            delete axios.defaults.headers.common['Authorization']
            resolve()
        })
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