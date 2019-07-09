const $tableStudent = $('#table-student');

function getActionButton(username) {
  return `<button href="#">Delete</button>`;
}

const dataTableProp = {
  ajax: {
    dataSrc: json => {
      json.recordsTotal = json.length;
      json.recordsFiltered = json.length;
      return json;
    },
    url: `${studentsApi}/${organizationIds}`,
  },
  columns: [
    {data: 'name'},
    {data: 'username'},
    {data: 'email'},
    {data: 'role'},
    {
      data: 'username',
      render: (data) => {
        return getActionButton(data);
      },
    },
  ],
  dom: 'ftipr',
  processing: true,
  searching: false,
  serverSide: true,
};

$(document).ready(() => {
  $tableStudent.DataTable(dataTableProp);
});
