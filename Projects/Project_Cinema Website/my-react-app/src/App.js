import logo from './logo.svg';
import './testSwiper.css';

import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Layout from './Layout';


// now have 17 page except NoPage
import MainPage from './pages/main/MainPage';
import FoodSelectionPage from './pages/food-selection/FoodSelectionPage';
import MovieListPage from './pages/movie-list/MovieListPage';
import MoviesPage from './pages/movies/MoviesPage';
import PaymentPage from './pages/payment/PaymentPage';
import PromotionListPage from './pages/promotion-list/PromotionListPage';
import SeatSelectionPage from './pages/seat-selection/SeatSelectionPage';
import TicketConfirmPage from './pages/ticket-confirm/TicketConfirmPage';

import AboutUsPage from './pages/about-us/AboutUsPage';
import AdminPage from './pages/admin/AdminPage';
import AuthPage from './pages/auth/AuthPage';
import CinemaIntroPage from './pages/cinema-intro/CinemaIntroPage';
import CinemaListPage from './pages/cinema-list/CinemaListPage';
import ExperienceIntroPage from './pages/experience-intro/ExperienceIntroPage';
import ExperienceListPage from './pages/experience-list/ExperienceListPage';
import MovieIntroPage from './pages/movie-intro/MovieIntroPage';
import PromotionIntroPage from './pages/promotion-intro/PromotionIntroPage';

import NoPage from './NoPage';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<MainPage />} />
          <Route path="food-selection-page" element={<FoodSelectionPage />} />
          <Route path="movie-list-page" element={<MovieListPage />} />
          <Route path="movies-page" element={<MoviesPage />} />
          <Route path="payment-page" element={<PaymentPage />} />
          <Route path="promotion-list-page" element={<PromotionListPage />} />
          <Route path="seat-selection-page" element={<SeatSelectionPage />} />
          <Route path="ticket-confirm-page" element={<TicketConfirmPage />} />
          <Route path="about-us-page" element={<AboutUsPage />} />
          <Route path="admin-page" element={<AdminPage />} />
          <Route path="auth-page" element={<AuthPage />} />
          <Route path="cinema-intro-page" element={<CinemaIntroPage />} />
          <Route path="cinema-list-page" element={<CinemaListPage />} />
          <Route path="experience-intro-page" element={<ExperienceIntroPage />} />
          <Route path="experience-list-page" element={<ExperienceListPage />} />
          <Route path="movie-intro-page" element={<MovieIntroPage />} />
          <Route path="promotion-intro-page" element={<PromotionIntroPage />} />
          <Route path="*" element={<NoPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;