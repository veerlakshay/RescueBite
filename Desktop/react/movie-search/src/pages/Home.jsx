import MovieCard from "../components/MovieCard"
import { useState } from "react"


function Home() {

    const [searchQuery, setSearchQuery] = useState("");

    const movies = [
        { id: 1, title: "The Shawshank Redemption", release_date: 1994 },
        { id: 2, title: "The Godfather", release_date: 1972 },
        { id: 3, title: "The Dark Knight", release_date: 2008 },
    ]

    const handleSubmit = (e) => {
        e.preventDefault();
        alert(`Search query: ${searchQuery}`)
        setSearchQuery("");
    }
    return (
        <div className="home">
            <form onSubmit={handleSubmit} className="search-form">
                <input
                    type="text"
                    placeholder="Search movies..."
                    className="search-input"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />

                <button
                    type="submit"
                    className="search-button">
                    Search
                </button>

            </form>
            <div className="movies-grid">
                {movies.map((movie) => (
                    (<MovieCard key={movie.id} movie={movie} />)
                ))}
            </div>
        </div>
    )
}

export default Home;