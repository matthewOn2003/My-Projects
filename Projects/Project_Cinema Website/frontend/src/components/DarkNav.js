import { useAuth } from "../hooks/useAuth";


function DarkNav() {

    const { logout } = useAuth();

    const handleLogout = () => {
        logout();
    };

    return (
        <div className="DarkNav">
            <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
                <div className="container">
                    <a className="navbar-brand" href="/">Logo</a>

                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse justify-content-end" id="mynavbar">
                        <ul className="navbar-nav border border-white p-0 mx-5 ">
                            <li className="nav-item mx-3 ">
                                <a className="nav-link text-white" href="/secret/cinema-list-page">Cinema</a>
                            </li>
                            <li className="nav-item mx-3 ">
                                <a className="nav-link text-white" href="/secret/movie-list-page">Movies</a>
                            </li>
                            <li className="nav-item mx-3 ">
                                <a className="nav-link text-white" href="/secret/food-selection-page">Food</a>
                            </li>
                            <li className="nav-item mx-3 ">
                                <a className="nav-link text-white" href="/secret/promotion-list-page">Promotions</a>
                            </li>
                        </ul>
                        {/* <form className="d-flex">
                            <input className="form-control me-2" type="text" placeholder="Search" />
                            <button className="btn btn-primary" type="button">Search</button>
                        </form> */}
                    </div>

                    <button onClick={handleLogout}>Logout</button>
                </div>
            </nav>

        </div>
    );
}

export default DarkNav;