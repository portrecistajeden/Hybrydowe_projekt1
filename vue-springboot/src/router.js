import Vue from "vue";
import Router from "vue-router";
import AddBook from "./components/AddBook.vue";
import BooksList from "./components/BooksList.vue";

Vue.use(Router)

export default new Router({
    made:"history",
    routes:[
        {
          path:"/add",
          name:"add",
          component:AddBook
        },
        {
          path:"/",
          alias:"/books",
          name:"Books",
          component:BooksList
        }
    ]
});
