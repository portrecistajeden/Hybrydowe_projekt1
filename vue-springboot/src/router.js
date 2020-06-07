import Vue from "vue";
import Router from "vue-router";
import BooksList from "./components/BooksList.vue";
import Login from "./components/Login.vue";
import Register from "./components/Register.vue";
import Home from "./components/Home.vue";
import Logout from "./components/Logout.vue";
import AddBook from "./components/AddBook.vue";
import UsersList from "./components/UsersList.vue";
import BorrowedBooks from "./components/BorrowedBooks.vue";
import Loans from "./components/Loans.vue";
import Vuelidate from "vuelidate";
Vue.use(Router)
Vue.use(Vuelidate);
export default new Router({
    made:"history",
    routes:[
        {
          path:"/books",
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
        },
        {
          path:"/",
          component:Home
        },
        {
          path:"/logout",
          component:Logout
        },
        {
          path:"/addBook",
          component:AddBook
        },{
          path:"/users",
          component:UsersList
        },{
          path:"/loans",
          component:Loans
        },{
          path:"/borrow",
          component:BorrowedBooks
        }
    ],
    
});
