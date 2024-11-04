import { Component, Input } from '@angular/core';
import { Movie } from '../services/movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})

export class MovieListComponent {
  @Input() movies: Movie[] = [];
  
}