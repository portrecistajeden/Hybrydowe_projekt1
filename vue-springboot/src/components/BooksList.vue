<template>
  <div class="list row">
    <div class="col-md-8">
   <div class="form-group col-md-8">
    <input @keyup.enter="SearchingBook" class="search" v-model="searchValue">
    <select class="form-control" id="exampleFormControlSelect1" v-model="valueSelect" >
      <option >Title</option>
      <option>Authors</option>
      <option>Year of publishment</option>
    </select>
    </div>
      <div class="input-group mb-3">
      </div>
    </div>
    
   
    <div class="col-md-6">
      <h4>Books List</h4>
     
      <ul>
         <li v-for="book in library" :key="book.idBook">
                         <p>{{book.title}}</p>
                          <p>{{book.authors}} {{", "}} {{book.yearofpublishment}}</p> 
                          <input type="submit" @click="deleteBook(book.idBook)" value="Delete">
                           <!-- <input type="submit" @click="loansBook" value="Loans">   -->
         </li>
      </ul>
    </div>
    <div>
      
      <form>
          <label>Title</label>
         <p> <input
            v-model="bookTitle"
            type="text">
        </p>
         
          <label>Authors</label>
         <p> <input
            v-model="bookAuthors"
            type="text" >
        </p>
        
          <label>Year of publishment</label>
          <p> <input
            v-model="bookYearOfPublishment"
            type="text" >
        </p>
        <input type="submit" @click="addBook" value="Add">
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "BooksList",
  data() {
    return {
      library: [],
      bookTitle:'',
      bookAuthors:'',
      bookYearOfPublishment:null,
      searchValue:'',
      valueSelect:'Title'
    };
  },
 async mounted(){
           try{
            await axios.get('http://localhost:8080/books').then(books => this.library=books.data)
             
           }
           catch(e){
             console.error(e);
           }
   },
   methods:{
      async addBook(){
      try{
            await axios.post('http://localhost:8080/books',{
              title:this.bookTitle,
              authors:this.bookAuthors,
              yearofpublishment:this.bookYearOfPublishment
            });
            window.location.reload();
           }
           catch(e){
             console.error(e);
           }
      },
      async deleteBook(idBook){
      try{
            await axios.delete('http://localhost:8080/books/'+idBook);
           
            console.log(idBook);
             window.location.reload();
           }
           catch(e){
             console.error(e);
           }
      },

      async SearchingBook(){
         try{
           if(this.searchValue==""){
              await axios.get('http://localhost:8080/books').then(books => this.library=books.data)
           }
           else if(this.valueSelect==='Title'){
             console.log("halo")
               await axios.get('http://localhost:8080/books/title/'+this.searchValue).then(books => this.library=books.data)
           }
           else if(this.valueSelect==='Authors'){
               await axios.get('http://localhost:8080/books/authors/'+this.searchValue).then(books => this.library=books.data)
           }
          else {
             await axios.get('http://localhost:8080/books/year/'+this.searchValue).then(books => this.library=books.data)
       
          }
           }
           catch(e){
             console.error(e);
           }
      }

      
   }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
.search{
  display: flex;
  flex-direction: column;
  width: 250px;
}
</style>