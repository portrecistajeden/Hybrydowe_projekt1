import Vue from "vue";
import Router from "vue-router";
import BooksList from "./components/BooksList.vue";
import Login from "./components/Login.vue";
import Register from "./components/Register.vue";
import Vuelidate from "vuelidate";
Vue.use(Router)
Vue.use(Vuelidate);

export default new Router({
    made:"history",
    routes:[
        {
          path:"/",
         // alias:"/books",
         // name:"Books",
          component:BooksList
        },
        {
          path:"/login",
          //alias:"/",
         // name:"Login",
          component:Login
        },
        {
          path:"/register",
          component:Register
        }
    ]
});
