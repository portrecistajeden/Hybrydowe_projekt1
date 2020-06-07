<template>
  <div class="list row">
    <table>
      <tr>
        <th>
          Tytuł
        </th>
         <th>
          Autorzy
        </th>
         <th>
          Rok wydania
        </th>
        <th></th>
      </tr>
      <tr  v-for="book in borrowBooks" :key="book.idLoans">
        <th>
         {{book.idBook.title}}
        </th>
         <th>
         {{book.idBook.authors}}
        </th>
         <th>
          {{book.idBook.yearofpublishment}}
        </th>
        <th> <input type="submit"  @click="borrow(book.idBook.idBook)" value="Zwróc"></th>
      </tr>
    </table>
   
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
//import axios from 'axios'
export default {
  name: "BorrowedBooks",
  data() {
    return {
      searchValue:'',
      valueSelect:'Tytuł'
    };
  },
  computed:{
      ...mapGetters({
          borrowBooks:'borrowBooks',
           refr:'refr'
        }
      )
  },
   watch:{
    refr(){
       this.$store.dispatch('getBorrowedBooks')
    }
  },
 async mounted(){
           try{
         //   await axios.get('http://localhost:8080/books').then(books => this.library=books.data)
             this.$store.dispatch('getBorrowedBooks')
           }
           catch(e){
             
             console.error(e);
           }
   },
   methods:{
       borrow(idBook){
           try{
               //console.log(idBook)
         //   await axios.get('http://localhost:8080/books').then(books => this.library=books.data)
             this.$store.dispatch('borrowBook',idBook)
           }
           catch(e){
             console.log("tu")
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
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>