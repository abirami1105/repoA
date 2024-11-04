import { Injectable } from '@angular/core';

export interface Movie {
  title: string;
  genre: string;
  rating: number;
  description: string;
}

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private movies: Movie[] = [
    { title: 'Harry Potter', genre: 'Fantasy', rating: 8.8, description: 'A magical journey of a young wizard' },
    { title: 'The Shawshank Redemption', genre: 'Drama', rating: 9.3, description: 'A story of hope and friendship' },
    { title: 'The Dark Knight', genre: 'Action', rating: 9.0, description: 'A superhero film'},
    { title: 'The Silence of the Lambs', genre: 'Thriller', rating: 8.6, description: 'A hunt for a serial killer' },
    { title: 'Goodfellas', genre: 'Crime', rating: 8.7, description: 'The rise and fall of a gangster' },
    { title: 'Inception', genre: 'Sci-Fi', rating: 8.8, description: 'A mind-bending thriller' },
    { title: 'Pulp Fiction', genre: 'Crime', rating: 8.9, description: 'An intertwined tale of crime' },
    { title: 'Forrest Gump', genre: 'Drama', rating: 8.8, description: 'The extraordinary life of an ordinary man' },
    { title: 'The Matrix', genre: 'Sci-Fi', rating: 8.7, description: 'A hacker learns about the true nature of reality' },
    { title: 'Gladiator', genre: 'Action', rating: 8.5, description: 'A betrayed soldier seeks revenge' },
    { title: 'Jurassic Park', genre: 'Adventure', rating: 8.1, description: 'Dinosaurs run amok in a theme park' },
    { title: 'Interstellar', genre: 'Sci-Fi', rating: 8.6, description: 'A journey through space to save humanity' },
    { title: 'Titanic', genre: 'Romance', rating: 7.8, description: 'A tragic love story on the ill-fated ship' },
    { title: 'Avatar', genre: 'Sci-Fi', rating: 7.8, description: 'An ex-marine on a foreign planet' },
    { title: 'Toy Story', genre: 'Animation', rating: 8.3, description: 'Toys come to life and face new adventures' },
  ];
  
   


  constructor() { }

  getMovies(): Movie[] {
    return this.movies;
  }

  searchMovies(query: string, genre: string, rating: number): Movie[] {
    return this.movies.filter(movie =>
      (movie.title.toLowerCase().includes(query.toLowerCase()) || !query) &&
      (movie.genre === genre || !genre) &&
      (movie.rating >= rating || rating === 0)
    );
  }
}

