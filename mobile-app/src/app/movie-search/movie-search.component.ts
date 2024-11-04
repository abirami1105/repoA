import { Component } from '@angular/core';
import { MovieService, Movie } from '../services/movie.service';

@Component({
  selector: 'app-movie-search',
  templateUrl: './movie-search.component.html',
  styleUrls: ['./movie-search.component.css']
})
export class MovieSearchComponent {
  query: string = '';
  genre: string = '';
  rating: number = 0;
  movies: Movie[] = [];
  loading: boolean = false;
  error: string | null = null;
  genres: string[] = ['Sci-Fi', 'Crime', 'Action','Drama']; 

  constructor(private movieService: MovieService) {
    this.movies = this.movieService.getMovies();
  }

  onSearch() {
    this.loading = true;
    this.error = null;
    try {
      setTimeout(() => { 
        this.movies = this.movieService.searchMovies(this.query, this.genre, this.rating);
        this.loading = false;
      }, 500);
    } catch (error) {
      this.error = 'Error fetching movies';
      this.loading = false;
    }
  }
}