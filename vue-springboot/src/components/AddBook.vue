<template>
<div>
  <h1>ADDDDDDD</h1>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="title">Title</label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="book.title"
          name="title"
        />
      </div>

      <div class="form-group">
        <label for="authors">Authors</label>
        <input
        type="text"
          class="form-control"
          id="authors"
          required
          v-model="book.authors"
          name="authors"
        />
      </div>

        <div class="form-group">
        <label for="yearofpublishment">Year</label>
        <input
         type="number"
          class="form-control"
          id="yearofpublishment"
          required
          v-model="book.yearofpublishment"
          name="yearofpublishment"
        />
      </div>

      <button @click="saveTutorial" class="btn btn-success">Submit</button>
    </div>
</div>
  </div>
</template>


<script>
import BookDataService from "../services/BookDataService";

export default {
  name: "add-book",
  data() {
    return {
      book: {
        id: 0,
        title: "",
        authors: "",
        yearofpublishment:0
      },
      submitted: false
    };
  },
  methods: {
    saveTutorial() {
      var data = {
        title: this.book.title,
        authors: this.book.authors,
        yearofpublishment: this.book.yearofpublishment
      };

      BookDataService.create(data)
        .then(response => {
          this.book.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    }    
    
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>