<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
      </div>
    </div>
    <div class="col-md-6">
      <h4>Books List</h4>

      
      <ul>
         <li v-for="book in library" :key="book.idBook">
                            {{book.title}}
                </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "BooksList",
  data() {
    return {
      library: []
     
    };
  },
 async mounted(){
           try{
            await axios.get('http://localhost:8080/books').then(books => this.library=books.data)
           }
           catch(e){
             console.error(e);
           }
            // axios.get(url+'/books').then((books) =>
            // this.library=books.data
            // );
        

  //  BookDataService.getAll()
  //       .then(response => {
  //         //this.books = response.data;
  //         console.log(response.data);
  //       })
  //       .catch(e => {
  //         console.log(e);
  //       });
   }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>