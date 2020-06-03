import Vue from "vue";
import Router from "vue-router";
import AddBook from "./components/AddBook.vue";
import BooksList from "./components/BooksList.vue";
import vSelect from 'vue-select';
import VueDropdown from 'vue-dynamic-dropdown'
import {DropDownListPlugin} from '@syncfusion/ej2-vue-dropdowns'

Vue.component('v-select', vSelect)
Vue.component('vue-dropdown', VueDropdown);
Vue.use(Router)
Vue.use(DropDownListPlugin)


export default new Router({
    made:"history",
    routes:[
        {
          path:"/books/add",
          name:"AddBook",
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
