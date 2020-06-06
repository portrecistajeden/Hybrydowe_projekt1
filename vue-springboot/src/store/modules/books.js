import axios from 'axios';

const state={
    library:[],
    refresh:0,
    book:{}
}

const getters={
    library: state=>{
        return state.library
    },

    refresh:state=>{
        return state.refresh
    },
    book:state=>{
        return state.book
    }
    
}

//wywołuje axios'owe puknięcie
const actions={
    getBooks({commit}){
         axios.get('http://localhost:8080/books')
         .then(result=>commit('LIBRARY',result.data))
           
    },

    deleteBook({commit},idBook){
         axios.delete('http://localhost:8080/books/'+idBook)
         .then(()=>commit('REFRESH'))
    },

    addBook({commit},book){
         axios.post('http://localhost:8080/books',book)
         .then(()=>commit('REFRESH'))
    },
    searchTitle({commit},searchValue){
         axios.get('http://localhost:8080/books/title/'+searchValue)
        .then(result=>commit('LIBRARY',result.data))
    },
    searchAuthors({commit},searchValue){
         axios.get('http://localhost:8080/books/authors/'+searchValue)
        .then(result=>commit('LIBRARY',result.data))
    },
    searchYear({commit},searchValue){
         axios.get('http://localhost:8080/books/year/'+searchValue)
        .then(result=>commit('LIBRARY',result.data))
    }
}

//modyfikacje stanu
const mutations={
    LIBRARY(state,library){
        state.library=library
    },
    REFRESH(state){
        state.refresh=++state.refresh
    }
}


//export
export default{
    state,
    getters,
    actions,
    mutations
}