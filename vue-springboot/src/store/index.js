import Vue from 'vue'
import Vuex from 'vuex'
import books from './modules/books'
import auth from './modules/auth'
import users from './modules/users'
import loans from './modules/loans'
Vue.use(Vuex)
export default new Vuex.Store({
  modules:{
      books,
      auth,
      users,
      loans
  },
  state:{
    LoggedUser:{
        login:"",
        
    },
    isLoggedIn :localStorage.getItem('token')
  }
})