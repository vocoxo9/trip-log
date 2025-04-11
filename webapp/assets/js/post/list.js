$(() => {
    $('.page-item').click(function(event) {
        event.preventDefault()

        const number = $(this).text().trim()
        if (!number) {
            return
        }

        let url = window.location.href
        if (url.indexOf('?') > -1) {
            url = url.replace(/([?&])page=\d+/, '?page=' + number)
        } else {
            url += `?page=${number}`
        }

        window.location.href = url
    })
})