import Vue from 'vue'
import Vuex from 'vuex'
import books from './modules/books'
import auth from './modules/auth'
import users from './modules/users'
Vue.use(Vuex)
export default new Vuex.Store({
  modules:{
      books,
      auth,
      users
  },
  state:{
    LoggedUser:{
        login:""
    }
  }
})