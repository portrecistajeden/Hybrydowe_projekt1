import http from "../http-common";
const url='http://localhost:8080'
class BookDataService{
    getAll(){
        return http.get(url+"/books");
    }

    create(data){
        return http.post("/books", data);
    }
}

export default new BookDataService();