import React from 'react';

function CategoryTabList(props) {
    const categories = props.categories;

    return (
        <div className="CategoryTabList">
            <ul className="d-flex flex-row flex-wrap justify-content-between px-5" id="myTab" role="tablist">
                {categories.map((category, categoryIndex) => (
                    <li key={categoryIndex} className="list-unstyled" role="presentation">
                        <a className="nav-link border border-white px-5 py-2"
                            href={`#${toHyphenPattern(category)}`}>
                            {category}
                        </a>
                    </li>
                ))}
            </ul>
        </div>
    );
}

function toHyphenPattern(string) {
    return string.toLowerCase().split(' ').join('-');
}

export default CategoryTabList;
